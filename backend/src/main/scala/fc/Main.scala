package fc

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{ExceptionHandler, RejectionHandler, Route}
import ch.megard.akka.http.cors.scaladsl.CorsDirectives.cors

import scala.concurrent.ExecutionContext

object Main {

  implicit def rejectionHandler: RejectionHandler =
    RejectionHandler.newBuilder().handleNotFound {
      complete(Response.NotFound)
    }.result()

  implicit def exceptionHandler: ExceptionHandler =
    ExceptionHandler {
      case e: Throwable => ctx => ctx.complete(Response.InternalServerError(e))
    }

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("fullstack-challenge")
    implicit val executionContext: ExecutionContext = system.dispatcher

    val _ = Http().newServerAt(Config.Rest.host, Config.Rest.port).bind(routes).map { _ =>
      system.log.info(
        s"Fullstack challenge backend started successfully on ${Config.Rest.host}:${Config.Rest.port.toString}!"
      )
    }
  }

  def routes: Route =
    (cors() & pathPrefix("api")) {
      (path("hello") & get) {
        complete(Response.OK("[]"))
      }
    }

}

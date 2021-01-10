package fc

import akka.http.scaladsl.model.MediaTypes.`application/json`
import akka.http.scaladsl.model.{HttpEntity, HttpResponse, StatusCodes}

object Response {
  def InternalServerError(e: Throwable): HttpResponse =
    HttpResponse(StatusCodes.InternalServerError, entity = HttpEntity(e.getMessage))

  def OK(json: String): HttpResponse =
    HttpResponse(StatusCodes.OK, entity = HttpEntity(`application/json`, json))

  val NotFound: HttpResponse = HttpResponse(StatusCodes.NotFound)
}

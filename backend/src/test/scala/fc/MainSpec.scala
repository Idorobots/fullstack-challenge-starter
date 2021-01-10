package fc

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest._
import funspec._
import matchers._

class MainSpec extends AnyFunSpec with should.Matchers with ScalatestRouteTest {
  describe("MainSpec") {
    it("should respond to hello/ requests") {
      implicit val system: ActorSystem = ActorSystem("test")
      implicit val routes: Route = Route.seal(Main.routes)

      Get(s"/api/hello") ~> routes ~> check {
        status shouldBe StatusCodes.OK
      }
    }

    it("should respond with 404 to unknown routes") {
      implicit val system: ActorSystem = ActorSystem("test")
      implicit val routes: Route = Route.seal(Main.routes)

      Get(s"/api/some/other/route") ~> routes ~> check {
        status shouldBe StatusCodes.NotFound
      }
    }

  }
}

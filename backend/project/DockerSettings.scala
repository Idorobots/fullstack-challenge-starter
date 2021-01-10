import com.typesafe.sbt.packager.docker.{Cmd, CmdLike, ExecCmd}
import sbt._

object DockerSettings {

  val additionalMappings = Seq(
    file("src/main/resources/application.conf") -> "application.conf"
  )

}

import com.typesafe.sbt.packager.docker.{Cmd, CmdLike, ExecCmd}
import sbt._

object DockerSettings {

  def dockerCommands(name: String): Seq[CmdLike] = Seq(
    Cmd("FROM", "phusion/baseimage:latest"),
    Cmd("MAINTAINER", "Kajetan Rzepecki <k@idorobots.org>"),
    Cmd("ADD", s"opt/docker /etc/$name"),
    Cmd("RUN", "apt-get update && apt-get install -y default-jre"),
    Cmd("WORKDIR", s"/etc/$name"),
    ExecCmd("CMD", s"/etc/$name/bin/$name", s"-Dconfig.file=/etc/$name/application.conf"))

  val additionalMappings = Seq(
    file("src/main/resources/application.conf") -> "application.conf"
  )
}

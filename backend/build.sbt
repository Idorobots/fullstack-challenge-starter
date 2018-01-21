name := "obstacle-course"
version := "0.0.1"
scalaVersion := "2.12.4"

val akkaVsn = "2.5.9"
val akkaHttpVsn = "10.0.11"

libraryDependencies ++= Seq(
  "ch.megard"                  %% "akka-http-cors"       % "0.2.2",
  "com.typesafe"               % "config"                % "1.3.0",
  "com.typesafe.akka"          %% "akka-actor"           % akkaVsn,
  "com.typesafe.akka"          %% "akka-http"            % akkaHttpVsn,
  "de.heikoseeberger"          %% "akka-http-json4s"     % "1.20.0-RC1",
  "org.json4s"                 %% "json4s-native"        % "3.5.0",
  "org.json4s"                 %% "json4s-ext"           % "3.5.0"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka"   %% "akka-testkit"         % akkaVsn % "test",
  "com.typesafe.akka"   %% "akka-http-testkit"    % akkaHttpVsn % "test",
  "org.scalatest"       %% "scalatest" % "3.0.1"  % "test"
)

scalacOptions ++= Seq(
  "-feature", "-unchecked", "-deprecation", "-encoding", "utf8",
  "-Xfatal-warnings", "-Yno-adapted-args", "-Yrangepos", "-Ywarn-dead-code",
  "-Ywarn-inaccessible", "-Ywarn-infer-any", "-Ywarn-nullary-override",
  "-Ywarn-numeric-widen", "-Ywarn-unused", "-Ywarn-unused-import"
)

wartremoverErrors in (Compile, compile) ++= Warts.all
wartremoverErrors in Test ++= Warts.allBut(Wart.NonUnitStatements)

coverageMinimum := 90
coverageFailOnMinimum := false // FIXME Set to true

enablePlugins(JavaAppPackaging)
dockerUpdateLatest := true
mappings in Universal ++= DockerSettings.additionalMappings
dockerCommands := DockerSettings.dockerCommands("obstacle-course")

addCommandAlias("clean-compile", ";clean;scalastyle;compile")
addCommandAlias("clean-test", ";clean;scalastyle;test:scalastyle;coverage;test;coverageReport")

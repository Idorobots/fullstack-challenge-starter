name := "fullstack-challenge-be"
version := "0.0.1"
scalaVersion := "2.13.4"

val akkaVsn = "2.6.10"
val akkaHttpVsn = "10.2.2"

libraryDependencies ++= Seq(
  "ch.megard"           %% "akka-http-cors"       % "1.1.1",
  "com.beachape"        %% "enumeratum-json4s"    % "1.6.0",
  "com.typesafe"        %  "config"               % "1.4.1",
  "com.typesafe.akka"   %% "akka-actor"           % akkaVsn,
  "com.typesafe.akka"   %% "akka-stream"          % akkaVsn,
  "com.typesafe.akka"   %% "akka-http"            % akkaHttpVsn,
  "de.heikoseeberger"   %% "akka-http-json4s"     % "1.35.3",
  "org.json4s"          %% "json4s-native"        % "3.6.10",
  "org.json4s"          %% "json4s-ext"           % "3.6.10"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka"   %% "akka-testkit"         % akkaVsn % "test",
  "com.typesafe.akka"   %% "akka-http-testkit"    % akkaHttpVsn % "test",
  "org.scalatest"       %% "scalatest"            % "3.2.2"  % "test"
)

scalacOptions ++= Seq(
  "-feature", "-unchecked", "-deprecation", "-encoding", "utf8",
  "-Xfatal-warnings", "-Xlint"
)

wartremoverErrors in (Compile, compile) ++= Warts.all
wartremoverErrors in Test ++= Warts.allBut(Wart.NonUnitStatements)

coverageMinimum := 90
coverageFailOnMinimum := false // FIXME Set to true

enablePlugins(JavaAppPackaging)
dockerUpdateLatest := true
mappings in Universal ++= DockerSettings.additionalMappings

addCommandAlias("clean-compile", ";clean;scalastyle;compile")
addCommandAlias("clean-test", ";clean;scalastyle;test:scalastyle;coverage;test;coverageReport")

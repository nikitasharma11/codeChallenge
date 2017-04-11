name := """coding_challenge"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

routesGenerator := StaticRoutesGenerator

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.scalaz" %% "scalaz-core" % "7.2.4"
)



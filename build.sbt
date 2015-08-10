name := "helloscala"

version := "1.0.0"

scalaVersion := "2.11.6"

val scalazVersion = "7.1.3"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "junit" % "junit" % "4.12" % "test",
  "org.specs2" %% "specs2" % "2.4.17" % "test"
)

initialCommands in console := "import scalaz._, Scalaz._"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

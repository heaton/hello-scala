name := "helloscala"

version := "1.0.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.json4s" %% "json4s-native" % "3.2.11",
  "junit" % "junit" % "4.11" % "test",
  "org.specs2" %% "specs2" % "2.4.2" % "test"
)

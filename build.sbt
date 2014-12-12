name := """ActivatorCustomerApi"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  cache,
  "joda-time" % "joda-time" % "2.6",
  "commons-lang" % "commons-lang" % "2.2",
  "com.wordnik" %% "swagger-play2" % "1.3.11"
)

resolvers ++= Seq(
      "typesafe-actifactory" at "http://typesafe.artifactoryonline.com/typesafe/repo/")
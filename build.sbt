ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "config-experiments",
    libraryDependencies ++= Seq(
      "com.typesafe"           % "config"     % "1.4.2",
      "com.github.pureconfig" %% "pureconfig" % "0.17.4"
    )
  )

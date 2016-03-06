name := "akka-stream-demo"
 
version := "0.1.0"
 
scalaVersion := "2.11.7"

val akkaVersion = "2.3.7"

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

lazy val commonSettings = Seq(
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    //"com.typesafe.akka" %% "akka-stream-experimental" % "2.0-M2"
    "com.typesafe.akka" % "akka-stream_2.11" % "2.4.2"
  ),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
)

lazy val scalaSeed = project
  .in(file(".") / "scala-demo-seed")
  .settings(commonSettings: _*)

lazy val scalaDemo = project
  .in(file(".") / "scala-demo")
  .settings(commonSettings: _*)

lazy val javaDemo = project
  .in(file(".") / "java-demo")
  .settings(commonSettings: _*)
  .settings(commonSettings: _*)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")
scalacOptions ++= Seq("-feature")

name := """jsonspace01"""

version := "1.0"

scalaVersion := "2.11.7"

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies ++= Seq(
	"com.typesafe.play" % "play-json_2.11" % "2.5.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11"
 )

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"


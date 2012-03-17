import sbt._
import Keys._


object ApplicationBuild extends Build {

    val appName         = "play-2.0-amazon-s3"
    val appVersion      = "1.0"

    val appDependencies = Seq(
    		"play" %% "play" % "2.0-RC1-SNAPSHOT",
    		"com.amazonaws" % "aws-java-sdk" % "1.3.0"
    )
    
    val main = Project(appName, base = file(".")).settings(
	    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
	
	    version := appVersion,

	    libraryDependencies ++= appDependencies
	)

}

import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "amazon-s3"
    val appVersion      = "1.0"

    val appDependencies = Seq(
    		"com.amazonaws" % "aws-java-sdk" % "1.3.0"
    )
    
    val main = play.Project(appName, appVersion, appDependencies).settings(
       organization := "stephen-patrick", 
       publishArtifact in (Compile, packageDoc) := false
    )

}

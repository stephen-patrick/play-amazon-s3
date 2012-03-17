resolvers ++= Seq(
    Resolver.defaultLocal,
    DefaultMavenRepository,
    //Resolver.url("Local Repository", url("file:///home/stephen/software/play-2.0-beta/Play20/repository")),
    Resolver.url("Play", url("http://download.playframework.org/ivy-releases/"))(Resolver.ivyStylePatterns),
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Typesafe Other Repository" at "http://repo.typesafe.com/typesafe/repo/"
)

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0-M3")

addSbtPlugin("play" % "sbt-plugin" % "2.0-RC1-SNAPSHOT")

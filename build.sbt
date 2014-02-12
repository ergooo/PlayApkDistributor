name := "PlayApkDistributor"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.wordnik" %% "swagger-play2" % "1.3.2",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.squeryl" %% "squeryl" % "0.9.5-6",
  "org.scalatest" %% "scalatest" % "2.0.RC3" % "test"
)

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0.RC3" % "test"

resolvers += Resolver.url("swagger-core-github-repo", url("http://wordnik.github.com/repository"))(Resolver.ivyStylePatterns)


play.Project.playScalaSettings

onLoadMessage <<= (name,crossVersion,scalaVersion,scalaBinaryVersion,onLoadMessage){
  (name,crossV,scalaV,binaryV,currentMessage) =>
  println("\n" + name + "\nscalaVersion = "+ scalaV + ", crossVersion = " + crossV + ", binaryVersion = " + binaryV + "\n")
  currentMessage
}


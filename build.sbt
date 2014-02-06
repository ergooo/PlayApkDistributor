name := "PlayApkDistributor"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.wordnik" %% "swagger-play2" % "1.3.2"
)

resolvers += Resolver.url("swagger-core-github-repo", url("http://wordnik.github.com/repository"))(Resolver.ivyStylePatterns)


play.Project.playScalaSettings

onLoadMessage <<= (name,crossVersion,scalaVersion,scalaBinaryVersion,onLoadMessage){
  (name,crossV,scalaV,binaryV,currentMessage) =>
  println("\n" + name + "\nscalaVersion = "+ scalaV + ", crossVersion = " + crossV + ", binaryVersion = " + binaryV + "\n")
  currentMessage
}


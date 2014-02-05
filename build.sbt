name := "PlayApkDistributor"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache
)     

play.Project.playScalaSettings

onLoadMessage <<= (name,crossVersion,scalaVersion,scalaBinaryVersion,onLoadMessage){ 
  (name,crossV,scalaV,binaryV,currentMessage) =>
  println("\n" + name + "\nscalaVersion = "+ scalaV + ", crossVersion = " + crossV + ", binaryVersion = " + binaryV + "\n")
  currentMessage
}


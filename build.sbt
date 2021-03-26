name := "bck-transform"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.4.0"
libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"
libraryDependencies += "com.github.ywilkof" % "spark-jobs-rest-client" % "1.3.9"


mainClass in assembly := Some("com.avel.data.Runner")

assemblyOutputPath := {
  new File("/Users/pavel/devcore/playground/bckTransform")
}
assemblyJarName in assembly := "bck-transform.jar"


assemblyOption in assembly :=
  (assemblyOption in assembly).value.copy(includeScala = true, includeDependency = true)

test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
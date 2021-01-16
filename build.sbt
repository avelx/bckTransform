name := "bck-transform"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"

libraryDependencies += "com.github.pureconfig" %% "pureconfig" % "0.14.0"

mainClass in assembly := Some("com.avel.data.Runner")

assemblyJarName in assembly := "bck-transform.jar"

assemblyOption in assembly :=
  (assemblyOption in assembly).value.copy(includeScala = true, includeDependency = true)

test in assembly := {}

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
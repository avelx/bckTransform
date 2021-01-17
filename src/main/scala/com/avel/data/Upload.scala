package com.avel.data

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.conf._

object Upload extends App {

  import org.apache.hadoop.fs.FileSystem

  val conf = new Configuration
  conf.set("fs.defaultFS", "hdfs://delta.avel.local:9000")
  val fs = FileSystem.get(conf)

  fs.copyFromLocalFile(
    new Path("/Users/pavel/devcore/playground/bckTransform/target/scala-2.12/bck-transform.jar"),
    new Path("/artifacts/bck-transform.jar")
  )
}

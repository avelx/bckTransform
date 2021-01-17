package com.avel.data

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.hadoop.conf._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Hdfs extends App {

  import org.apache.hadoop.fs.FileSystem

//  def upload(srcFileName: String, dstFileName: String)(implicit conf: Configuration) : Future[_] = {
//    Future {
//      val fs = FileSystem.get(conf)
//      fs.copyFromLocalFile(new Path(srcFileName), new Path(dstFileName))
//    }
//  }

  val conf = new Configuration
  conf.set("fs.defaultFS", "hdfs://delta.avel.local:9000")
  val fs = FileSystem.get(conf)

  fs.copyFromLocalFile(
    new Path("/Users/pavel/devcore/playground/bckTransform/target/scala-2.12/bck-transform.jar"),
    new Path("/artifacts/bck-transform.jar")
  )
}

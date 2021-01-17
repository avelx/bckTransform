package com.avel.data

import scala.util.Random

object Runner extends App {
  println("Main runner")

  import org.apache.spark.SparkConf
  import org.apache.spark.sql.SparkSession

  val conf = new SparkConf()
    .setMaster("spark://alpha.avel.local:7077")
    .setAppName("Runner")
//    .set("spark.dynamicAllocation.enabled", "true")
//    .set("spark.executor.cores", "*")
//    .set("spark.dynamicAllocation.minExecutors", "1")
//    .set("spark.dynamicAllocation.maxExecutors", "20")

  val spark = SparkSession
    .builder()
    .appName("basic example")
    .config(conf)
    .getOrCreate()

  val df = spark.read.csv("hdfs://delta.avel.local:9000/data/binace-crypto-klines/datasets/01-2018/01-2018")


  val count: Long = df.count()
  val list = Array[Long](count).toList

  import spark.implicits._

  val res = list.toDF()
  res.coalesce(1)
    .write
    .csv(s"hdfs://delta.avel.local:9000/data/home/" +
      s"${Random.alphanumeric.take(5).toList.mkString("")}result.csv")
  //val count = df.count()
  //println(count)

  spark.close()

}
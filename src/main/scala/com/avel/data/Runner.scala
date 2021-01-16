package com.avel.data

object Runner extends App {
  println("Main runner")

  import org.apache.spark.SparkConf
  import org.apache.spark.sql.SparkSession

  val conf = new SparkConf()
    .setMaster("local[2]")
    .setAppName("SomeApp")

  val spark = SparkSession
    .builder()
    .appName("basic example")
    .config(conf)
    .getOrCreate()

  val df = spark.read.csv("hdfs://delta.avel.local:9000/data/binace-crypto-klines/datasets/01-2018/01-2018")

  val count = df.count()

  println(count)

  spark.close()

}
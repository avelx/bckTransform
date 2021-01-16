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

  val df = spark.read.csv("/data/binace-crypto-klines/datasets/*")

  val count = df.count()

  spark.close()

}
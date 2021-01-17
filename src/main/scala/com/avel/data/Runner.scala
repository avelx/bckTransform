package com.avel.data

import com.avel.data.model.Record
import org.apache.spark.sql.functions.col

import scala.util.Random

object Runner extends App {
  println("Main runner")

  import org.apache.spark.SparkConf
  import org.apache.spark.sql.SparkSession

  val conf = new SparkConf()
    .setMaster("spark://alpha.avel.local:7077")
//    .setMaster("local[*]")
    .setAppName("Runner")
    .set("spark.driver.port", "51000")
//    .set("spark.fileserver.port", "51811")
    //    .set("spark.replClassServer.port", "51813")
    .set("spark.broadcast.port", "51815")
    .set("spark.blockManager.port", "51800")
    .set("spark.executor.port", "51810")

  //    .set("spark.dynamicAllocation.enabled", "true")
//    .set("spark.executor.cores", "*")
//    .set("spark.dynamicAllocation.minExecutors", "1")
//    .set("spark.dynamicAllocation.maxExecutors", "20")

  val spark = SparkSession
    .builder()
    .appName("RePartitionJob")
    .config(conf)
    .getOrCreate()

  val dates = List("01-2018", "02-2018", "03-2018", "11-2017", "12-2017")

  import spark.implicits._

  val ds = spark
    .read
    .option("header", "true")
    .csv("hdfs://delta.avel.local:9000/data/binace-crypto-klines/datasets/01-2018/01-2018/ADABTC.csv")
    .as[Record]

  ds
    .repartition( col("Open_time") )
    .write
    .parquet(s"hdfs://delta.avel.local:9000/dataStore/${Random.alphanumeric.take(5).toList.mkString("")}-res-ABC")

//  val res = list.toDF()
//  res.coalesce(1)
//    .write
//    .csv(s"hdfs://delta.avel.local:9000/data/" +
//      s"${Random.alphanumeric.take(5).toList.mkString("")}result.csv")

  spark.close()

}
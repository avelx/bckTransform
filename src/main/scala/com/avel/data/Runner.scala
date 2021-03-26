package com.avel.data

import com.avel.data.model.{Record, Record2}
import org.apache.spark.sql.functions.col

import scala.util.Random

object Runner extends App {
  println("Main runner")

  import org.apache.spark.SparkConf
  import org.apache.spark.sql.SparkSession

  val conf = new SparkConf()
  .setMaster("spark://gamma.avel.local:7077")
//    .setMaster("local[*]")
    .setAppName("DataRePatitioner")
    .set("spark.driver.port", "51000")
    .set("spark.broadcast.port", "51815")
    .set("spark.blockManager.port", "51800")
    .set("spark.executor.port", "51810")
    .set("spark.eventLog.enabled", "true")
    .set("spark.eventLog.dir", "hdfs://delta.avel.local:9000/history-server/spark-logs")

  //    .set("spark.dynamicAllocation.enabled", "true")
//    .set("spark.executor.cores", "*")
//    .set("spark.dynamicAllocation.minExecutors", "1")
//    .set("spark.dynamicAllocation.maxExecutors", "20")

  val spark = SparkSession
    .builder()
    .config(conf)
    .getOrCreate()

  val dates = List("01-2018", "02-2018", "03-2018", "11-2017", "12-2017")

  import spark.implicits._
  import com.avel.data.data.Func._

  dates.foreach(date => {

    val ds = spark
      .read
      .option("header", "true")
      .csv(s"hdfs://delta.avel.local:9000/data/binace-crypto-klines/datasets/$date/$date/")
      .as[Record]

    val dsEnhanced = ds
      .map(add_hour)
      .as[Record2]

    val batchId = Random.alphanumeric.take(5).mkString("")
    dsEnhanced
      .repartition( col("Hour") )
      .write
      .json(s"hdfs://delta.avel.local:9000/dataStore/json/$date/$batchId")
  })

  spark.close()

}
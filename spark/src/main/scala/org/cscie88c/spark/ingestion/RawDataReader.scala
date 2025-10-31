package org.cscie88c.spark.ingestion

import org.apache.spark.sql.{DataFrame, SparkSession}

object RawDataReader {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("RawDataReader")
      .master("local[*]")
      .getOrCreate()

    val filePath = "Data/bronze/yellow_tripdata_2025-01.parquet"

    val df = spark.read.parquet(filePath)

    println(s"Schema for $filePath:")
    df.printSchema()

    // Optional: sample a few rows to inspect
    df.show(5, truncate = false)

    spark.stop()
  }
}

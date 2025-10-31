package org.cscie88c.spark.ingestion

import org.apache.spark.sql.{DataFrame, SparkSession}

object RawDataReader {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("RawDataReader")
      .master("local[*]")
      .getOrCreate()

    val filePath = "../Data/bronze/yellow_tripdata_2025-01.parquet"

    val df = spark.read.parquet(filePath)

    println(s"Schema for $filePath:")
    df.printSchema()

    // Sample a few rows to inspect
    df.show(5, truncate = false)

    spark.stop()
  }
}


/*
First output to review

|VendorID|tpep_pickup_datetime|tpep_dropoff_datetime|passenger_count|trip_distance|RatecodeID|store_and_fwd_flag|PULocationID|DOLocationID|payment_type|fare_amount|extra|mta_tax|tip_amount|tolls_amount|improvement_surcharge|total_amount|congestion_surcharge|Airport_fee|cbd_congestion_fee|
[info] +--------+--------------------+---------------------+---------------+-------------+----------+------------------+------------+------------+------------+-----------+-----+-------+----------+------------+---------------------+------------+--------------------+-----------+------------------+
[info] |1       |2025-01-01 00:18:38 |2025-01-01 00:26:59  |1              |1.6          |1         |N                 |229         |237         |1           |10.0       |3.5  |0.5    |3.0       |0.0         |1.0                  |18.0        |2.5                 |0.0        |0.0               |
[info] |1       |2025-01-01 00:32:40 |2025-01-01 00:35:13  |1              |0.5          |1         |N                 |236         |237         |1           |5.1        |3.5  |0.5    |2.02      |0.0         |1.0                  |12.12       |2.5                 |0.0        |0.0               |
[info] |1       |2025-01-01 00:44:04 |2025-01-01 00:46:01  |1              |0.6          |1         |N                 |141         |141         |1           |5.1        |3.5  |0.5    |2.0       |0.0         |1.0                  |12.1        |2.5                 |0.0        |0.0               |
[info] |2       |2025-01-01 00:14:27 |2025-01-01 00:20:01  |3              |0.52         |1         |N                 |244         |244         |2           |7.2        |1.0  |0.5    |0.0       |0.0         |1.0                  |9.7         |0.0                 |0.0        |0.0               |
[info] |2       |2025-01-01 00:21:34 |2025-01-01 00:25:06  |3              |0.66         |1         |N                 |244         |116         |2           |5.8        |1.0  |0.5    |0.0       |0.0         |1.0                  |8.3         |0.0                 |0.0        |0.0               |
[info] +--------+--------------------+---------------------+---------------+-------------+----------+------------------+------------+------------+------------+-----------+-----+-------+----------+------------+---------------------+------------+--------------------+-----------+------------------+

*/
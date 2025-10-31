package org.cscie88c.spark.config

import org.apache.spark.sql.types._

// Following values are from the taxi_zone_lookup.csv

object BoroughSchema {
  val schema: StructType = StructType(Seq(
    StructField("LocationID", IntegerType, nullable = false),
    StructField("Borough", StringType, nullable = true),
    StructField("Zone", StringType, nullable = true),
    StructField("service_zone", StringType, nullable = true)
  ))
}

case class BoroughSchema (
    LocationID: Int,
    Borough: String,
    Zone: Int,              // Likely needs adjusting
    Service_zone: String    // Likely needs adjusting
    )

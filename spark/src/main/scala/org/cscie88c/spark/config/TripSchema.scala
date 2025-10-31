package org.cscie88c.spark.config

import org.apache.spark.sql.types._

// pickup time, dropoff time, fare, distance

case class TripSchema(
    id: Int,
    pickup_datetime: String,
    dropoff_datetime: String,
    passenger_count: Int,
    trip_distance: Double,
    PULocationID: Int, // Likely different class
    DOLocationID: Int, // Likely different class
    fare_amount: Double,
    extra: Double,
    tip_amount: Double,
    tolls_amount: Double,
    total_amount: Double
)

object TripSchema {
  val schema: StructType = StructType(Seq(
    StructField("driverID", IntegerType, nullable = true),
    StructField("pickup_datetime", TimestampType, nullable = true),
    StructField("dropoff_datetime", TimestampType, nullable = true),
    StructField("passenger_count", IntegerType, nullable = true),
    StructField("trip_distance", DoubleType, nullable = true),
    StructField("PULocationID", IntegerType, nullable = true),
    StructField("DOLocationID", IntegerType, nullable = true),
    StructField("fare_amount", DoubleType, nullable = true),
    StructField("extra", DoubleType, nullable = true),
    StructField("tip_amount", DoubleType, nullable = true),
    StructField("tolls_amount", DoubleType, nullable = true),
    StructField("total_amount", DoubleType, nullable = true)
  ))
}

package org.cscie88c.spark.config

import org.apache.spark.sql.types._

case class TripSchema(
    // id: Int,
    // pickup_datetime: String,
    // dropoff_datetime: String,
    // passenger_count: Int,
    // trip_distance: Double,
    // PULocationID: Int, // Likely different class
    // DOLocationID: Int, // Likely different class
    // fare_amount: Double,
    // extra: Double,
    // tip_amount: Double,
    // tolls_amount: Double,
    // total_amount: Double

    // These are all headers in the trip parquet file
    VendorID: String,
    tpep_pickup_datetime: String,
    tpep_dropoff_datetime: String,
    passenger_count: Int,
    trip_distance: Double,
    RatecodeID: String,
    store_and_fwd_flag: Boolean,
    PULocationID: String,
    DOLocationID: String,
    payment_type: Int,
    fare_amount: Double,
    extra: Double,
    mta_tax: Double,
    tip_amount: Double,
    tolls_amount: Double,
    improvement_surcharge: Double,
    total_amount: Double,
    congestion_surcharge: Double,
    Airport_fee: Double,
    cbd_congestion_fee: Double
)

// object TripSchema {
//   val tripSchema: StructType = StructType(Seq(
//     StructField("driverID", IntegerType, nullable = true),
//     StructField("pickup_datetime", TimestampType, nullable = true),
//     StructField("dropoff_datetime", TimestampType, nullable = true),
//     StructField("passenger_count", IntegerType, nullable = true),
//     StructField("trip_distance", DoubleType, nullable = true),
//     StructField("PULocationID", IntegerType, nullable = true),
//     StructField("DOLocationID", IntegerType, nullable = true),
//     StructField("fare_amount", DoubleType, nullable = true),
//     StructField("extra", DoubleType, nullable = true),
//     StructField("tip_amount", DoubleType, nullable = true),
//     StructField("tolls_amount", DoubleType, nullable = true),
//     StructField("total_amount", DoubleType, nullable = true)
//   ))
// }


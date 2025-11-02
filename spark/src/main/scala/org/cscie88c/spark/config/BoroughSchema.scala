package org.cscie88c.spark.config

import org.apache.spark.sql.types._

// Following values are from the taxi_zone_lookup.csv

case class BoroughSchema (
    LocationID: Int,
    Borough: String,
    Zone: Int,              // Likely needs adjusting
    Service_zone: String    // Likely needs adjusting
    )

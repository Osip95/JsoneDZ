package com.example.jsondz

import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("lat")
    val lat: Double,

    @SerializedName("long")
    val long: Double
)
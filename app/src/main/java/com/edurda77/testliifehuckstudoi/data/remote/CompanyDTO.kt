package com.edurda77.testliifehuckstudoi.data.remote


import com.google.gson.annotations.SerializedName

data class CompanyDTO(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("www")
    val www: String
)
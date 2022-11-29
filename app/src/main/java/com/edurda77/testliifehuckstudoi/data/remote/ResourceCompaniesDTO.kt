package com.edurda77.testliifehuckstudoi.data.remote


import com.google.gson.annotations.SerializedName

data class ResourceCompaniesDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String
)
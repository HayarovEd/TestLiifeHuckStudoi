package com.edurda77.testliifehuckstudoi.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface LiveHuckApi {

    @GET("test.php")
    suspend fun getData(
    ): List<ResourceCompaniesDTO>

    @GET("test.php")
    suspend fun getCompanyData(
        @Query("id") id: String
    ): List<CompanyDTO>
}
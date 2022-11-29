package com.edurda77.testliifehuckstudoi.data.repository

import com.edurda77.testliifehuckstudoi.data.mappers.toCompanyData
import com.edurda77.testliifehuckstudoi.data.mappers.toListCompanyData
import com.edurda77.testliifehuckstudoi.data.remote.LiveHuckApi
import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany
import com.edurda77.testliifehuckstudoi.domain.repository.LiveHuckRepository
import com.edurda77.testliifehuckstudoi.domain.utils.Resource
import javax.inject.Inject

class LiveHuckRepositoryImpl @Inject constructor(private val api: LiveHuckApi) :
    LiveHuckRepository {
    override suspend fun getAllData(): Resource<List<ItemCompany>> {
        return try {
            Resource.Success(
                data = api.getData(
                ).toListCompanyData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getCompanyData(id: String): Resource<CompanyData> {
        return try {
            Resource.Success(
                data = api.getCompanyData(id = id
                ).toCompanyData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}
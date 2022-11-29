package com.edurda77.testliifehuckstudoi.domain.repository

import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany
import com.edurda77.testliifehuckstudoi.domain.utils.Resource

interface LiveHuckRepository {

    suspend fun getAllData() : Resource<List<ItemCompany>>
    suspend fun getCompanyData(id:String) : Resource<CompanyData>
}
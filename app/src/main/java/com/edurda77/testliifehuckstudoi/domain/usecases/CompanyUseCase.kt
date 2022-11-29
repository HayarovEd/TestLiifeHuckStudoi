package com.edurda77.testliifehuckstudoi.domain.usecases

import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.utils.Resource

interface CompanyUseCase {

    suspend fun execute(id: String) : Resource<CompanyData>
}
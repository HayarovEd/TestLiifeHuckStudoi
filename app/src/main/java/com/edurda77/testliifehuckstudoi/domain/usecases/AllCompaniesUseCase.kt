package com.edurda77.testliifehuckstudoi.domain.usecases

import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany
import com.edurda77.testliifehuckstudoi.domain.utils.Resource

interface AllCompaniesUseCase {

    suspend fun execute() : Resource<List<ItemCompany>>
}
package com.edurda77.testliifehuckstudoi.domain.usecases

import com.edurda77.testliifehuckstudoi.domain.entity.CompanyData
import com.edurda77.testliifehuckstudoi.domain.repository.LiveHuckRepository
import com.edurda77.testliifehuckstudoi.domain.utils.Resource
import javax.inject.Inject

class CompanyUseCaseImpl @Inject constructor(
    private val repository: LiveHuckRepository
) : CompanyUseCase {
    override suspend fun execute(id: String): Resource<CompanyData> {
        return repository.getCompanyData(id = id)
    }
}
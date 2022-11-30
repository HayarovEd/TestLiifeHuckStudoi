package com.edurda77.testliifehuckstudoi.domain.usecases

import com.edurda77.testliifehuckstudoi.domain.entity.ItemCompany
import com.edurda77.testliifehuckstudoi.domain.repository.LiveHuckRepository
import com.edurda77.testliifehuckstudoi.domain.utils.Resource
import javax.inject.Inject

class AllCompaniesUseCaseImpl @Inject constructor(
    private val repository: LiveHuckRepository
) : AllCompaniesUseCase {
    override suspend fun execute(): Resource<List<ItemCompany>> {
        return repository.getAllData()
    }
}
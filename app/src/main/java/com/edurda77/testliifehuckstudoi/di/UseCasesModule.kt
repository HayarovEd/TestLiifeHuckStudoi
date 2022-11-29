package com.edurda77.testliifehuckstudoi.di

import com.edurda77.testliifehuckstudoi.domain.usecases.AllCompaniesUseCase
import com.edurda77.testliifehuckstudoi.domain.usecases.AllCompaniesUseCaseImpl
import com.edurda77.testliifehuckstudoi.domain.usecases.CompanyUseCase
import com.edurda77.testliifehuckstudoi.domain.usecases.CompanyUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {
    @Binds
    @Singleton
    abstract fun bindAllCompanyUseCase(
        allCompaniesUseCaseImpl: AllCompaniesUseCaseImpl
    ): AllCompaniesUseCase

    @Binds
    @Singleton
    abstract fun bindCompanyyUseCase(
        companiesUseCase: CompanyUseCaseImpl
    ): CompanyUseCase
}
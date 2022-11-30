package com.edurda77.testliifehuckstudoi.di

import com.edurda77.testliifehuckstudoi.data.repository.LiveHuckRepositoryImpl
import com.edurda77.testliifehuckstudoi.domain.repository.LiveHuckRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindLiveHuckRepository(
        liveHuckRepositoryImpl: LiveHuckRepositoryImpl
    ): LiveHuckRepository
}
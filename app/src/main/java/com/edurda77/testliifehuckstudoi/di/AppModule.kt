package com.edurda77.testliifehuckstudoi.di

import com.edurda77.testliifehuckstudoi.data.remote.LiveHuckApi
import com.edurda77.testliifehuckstudoi.domain.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLiveHuckApi(): LiveHuckApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LiveHuckApi::class.java)
    }
}
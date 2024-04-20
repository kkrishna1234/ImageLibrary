package com.example.myapplication.di

import com.example.myapplication.network.ApiService
import com.example.myapplication.network.ContentRepository
import com.example.myapplication.network.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun provideNewsFeedRepositoryImpl(
        apiService: ApiService
    ): ContentRepository {
        return ContentRepositoryImpl(apiService)
    }
}
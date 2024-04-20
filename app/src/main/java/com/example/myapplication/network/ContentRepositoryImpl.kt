package com.example.myapplication.network

import com.example.myapplication.network.models.Content
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val apiService: ApiService) : ContentRepository {

    override suspend fun getContent(): List<Content> {
        return apiService.getContent()
    }
}
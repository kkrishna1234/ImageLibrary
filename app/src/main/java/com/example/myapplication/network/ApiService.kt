package com.example.myapplication.network

import com.example.myapplication.network.models.Content
import retrofit2.http.GET

interface ApiService {

    @GET("content/misc/media-coverages?limit=100")
    suspend fun getContent(): List<Content>

}
package com.example.myapplication.network

import com.example.myapplication.network.models.Content

interface ContentRepository {
    suspend fun getContent(): List<Content>
}
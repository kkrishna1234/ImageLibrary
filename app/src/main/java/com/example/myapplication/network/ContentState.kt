package com.example.myapplication.network

sealed class ContentState {
    data class Content(val images: List<String?>) : ContentState()
    data class Error(val error: String) : ContentState()
}
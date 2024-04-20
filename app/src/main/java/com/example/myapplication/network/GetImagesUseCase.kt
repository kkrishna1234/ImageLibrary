package com.example.myapplication.network

import com.example.myapplication.network.models.Content
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val repository: ContentRepository) {

    suspend fun getImages(): List<String?> {
        return repository.getContent().map { content: Content ->
            content.thumbnail?.run {
                domain + "/" + basePath + "/0/" + key
            }
        }
    }

}
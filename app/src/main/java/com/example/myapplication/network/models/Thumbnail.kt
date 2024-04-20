package com.example.myapplication.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val id: String? = null,
    val version: Int? = null,
    val domain: String? = null,
    val basePath: String? = null,
    val key: String? = null,
    val qualities: ArrayList<Int> = arrayListOf(),
    val aspectRatio: Int? = null
)
package com.example.myapplication.network.models

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String? = null,
    val title: String? = null,
    val language: String? = null,
    val thumbnail: Thumbnail? = null,
    val mediaType: Int? = null,
    val coverageURL: String? = null,
    val publishedAt: String? = null,
    val publishedBy: String? = null,
    val backupDetails: BackupDetails? = BackupDetails()
)
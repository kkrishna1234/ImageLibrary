package com.example.myapplication.network.models

import kotlinx.serialization.Serializable

@Serializable
data class BackupDetails(
    val pdfLink: String? = null,
    val screenshotURL: String? = null
)
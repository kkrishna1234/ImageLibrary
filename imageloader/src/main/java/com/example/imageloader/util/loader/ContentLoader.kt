package com.example.imageloader.util.loader

import android.content.ContentResolver
import android.net.Uri
import com.example.imageloader.core.Loader
import com.example.imageloader.util.safeClose
import com.example.imageloader.util.safeCopyTo
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

class ContentLoader(private val contentResolver: ContentResolver) : Loader {

    override val schemes: List<String>
        get() = listOf("content")

    override fun load(uriString: String, file: File): Boolean {
        val uri = Uri.parse(uriString)
        var input: InputStream? = null
        var output: OutputStream? = null
        try {
            input = contentResolver.openInputStream(uri)
            output = FileOutputStream(file)
            return input
                ?.safeCopyTo(output)
                ?.takeIf { true } ?: false
        } finally {
            input?.safeClose()
            output?.safeClose()
        }
    }
}
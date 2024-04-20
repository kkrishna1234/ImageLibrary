package com.example.myapplication.cache

import android.content.Context
import android.graphics.Bitmap

class CacheRepository(
    val context: Context,
    val cacheSize: Int,
    val memoryCache: MemoryCache
) : ImageCache {
    override fun put(url: String, bitmap: Bitmap) {
        memoryCache.put(url, bitmap)
    }

    override fun get(url: String): Bitmap? {
        return memoryCache.get(url)
    }

    override fun clear() {
        memoryCache.clear()
    }
}

package com.example.imageloader

import android.content.Context
import com.example.imageloader.cache.DiskLruCache
import com.example.imageloader.core.Decoder
import com.example.imageloader.core.DiskCacheImpl
import com.example.imageloader.core.FileProvider
import com.example.imageloader.core.FileProviderImpl
import com.example.imageloader.core.ImageLoader
import com.example.imageloader.core.ImageLoaderImpl
import com.example.imageloader.core.MainExecutorImpl
import com.example.imageloader.core.MemoryCache
import com.example.imageloader.core.MemoryCacheImpl
import com.example.imageloader.util.BitmapDecoder
import com.example.imageloader.util.loader.ContentLoader
import com.example.imageloader.util.loader.UrlLoader
import com.example.imageloader.util.loader.FileLoader
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object SimpleImageLoader {

    private var imageLoader: ImageLoader? = null

    fun Context.imageLoader(): ImageLoader {
        return imageLoader ?: initImageLoader()
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun Context.initImageLoader(
        decoders: List<Decoder> = listOf(BitmapDecoder()),
        fileProvider: FileProvider = FileProviderImpl(
            cacheDir,
            DiskCacheImpl(DiskLruCache.create(cacheDir, 15728640L)),
            UrlLoader(),
            FileLoader(assets),
            ContentLoader(contentResolver)
        ),
        memoryCache: MemoryCache = MemoryCacheImpl(),
        mainExecutor: Executor = MainExecutorImpl(),
        backgroundExecutor: ExecutorService = Executors.newFixedThreadPool(10)
    ): ImageLoader {
        val loader = ImageLoaderImpl(
            fileProvider,
            decoders,
            memoryCache,
            mainExecutor,
            backgroundExecutor
        )
        imageLoader = loader
        return loader
    }

}

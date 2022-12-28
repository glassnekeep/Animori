package ru.glassnekeep.media_data

import androidx.compose.runtime.compositionLocalOf

interface MediaDataProvider {
    val mediaRepository: MediaRepository
}

val LocalMediaDataProvider = compositionLocalOf<MediaDataProvider> { error("No media data provided") }
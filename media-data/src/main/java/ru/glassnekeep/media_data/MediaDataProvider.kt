package ru.glassnekeep.media_data

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.media_data.use_cases.GetAnimeListUseCase
import ru.glassnekeep.media_data.use_cases.GetAnimeUseCase

interface MediaDataProvider {
    val getAnimeUseCase: GetAnimeUseCase
    val getAnimeListUseCase: GetAnimeListUseCase
    val mediaRepository: MediaRepository
    val dispatchers: AppDispatchers
}

val LocalMediaDataProvider = compositionLocalOf<MediaDataProvider> { error("No media data provided") }
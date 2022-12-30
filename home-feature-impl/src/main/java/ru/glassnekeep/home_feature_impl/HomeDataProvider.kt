package ru.glassnekeep.home_feature_impl

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.media_data.MediaRepository
import ru.glassnekeep.media_data.use_cases.GetAnimeListUseCase
import ru.glassnekeep.media_data.use_cases.GetAnimeUseCase

interface HomeDataProvider {
    //TODO Тут будет много всяких разных репозиториев скорее всего, а потом уже в UseCase фичи они будут использованы
    val scheduleRepository: ScheduleRepository
    val getAnimeListUseCase: GetAnimeListUseCase
    val getAnimeUseCase: GetAnimeUseCase
    val mediaRepository: MediaRepository
}

val LocalHomeDataProvider = compositionLocalOf<HomeDataProvider> { error("No home data provider found!") }
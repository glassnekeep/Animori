package ru.glassnekeep.home_feature_impl

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.anilist.services.AiringScheduleRemoteService
import ru.glassnekeep.anilist.services.MediaRemoteService

interface HomeDataProvider {
    //TODO Тут будет много всяких разных репозиториев скорее всего, а потом уже в UseCase фичи они будут использованы
    val scheduleRepository: ScheduleRepository
    val airingScheduleRemoteService: AiringScheduleRemoteService
    val mediaRemoteService: MediaRemoteService
}

val LocalHomeDataProvider = compositionLocalOf<HomeDataProvider> { error("No home data provider found!") }
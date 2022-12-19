package ru.glassnekeep.anilist.api.di

import ru.glassnekeep.anilist.services.AiringScheduleRemoteService
import ru.glassnekeep.anilist.services.MediaRemoteService

interface AnilistDataProvider  {
//    val pageSizes: PageSizes
//    val contentType: ContentType
//    val client: HttpClient
    val airingScheduleRemoteService: AiringScheduleRemoteService
    val mediaRemoteService: MediaRemoteService
}
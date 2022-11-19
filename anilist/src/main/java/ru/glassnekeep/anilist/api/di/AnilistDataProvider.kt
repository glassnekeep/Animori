package ru.glassnekeep.anilist.api.di

import io.ktor.client.*
import io.ktor.http.*
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.services.AiringScheduleRemoteService

interface AnilistDataProvider  {
//    val pageSizes: PageSizes
//    val contentType: ContentType
//    val client: HttpClient
    val airingScheduleRemoteService: AiringScheduleRemoteService
}
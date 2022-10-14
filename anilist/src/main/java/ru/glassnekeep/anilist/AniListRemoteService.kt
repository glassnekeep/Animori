package ru.glassnekeep.anilist

import io.ktor.client.*
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class AniListRemoteService @Inject constructor(
    private val client: HttpClient
) {

}
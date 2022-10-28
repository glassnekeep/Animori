package ru.glassnekeep.anilist

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.AnilistClient
import ru.glassnekeep.anilist.api.AnilistRequest
import ru.glassnekeep.anilist.api.MockedResponses
import ru.glassnekeep.anilist.api.MockedResponses.mediaResponse
import ru.glassnekeep.anilist.api.enums.*
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.character.CharacterConnection
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection
import ru.glassnekeep.anilist.api.models.domain.media.MediaCoverImage
import ru.glassnekeep.anilist.api.models.domain.media.MediaEdge
import ru.glassnekeep.anilist.api.models.domain.recommendation.RecommendationConnection
import ru.glassnekeep.anilist.api.models.domain.studio.StudioConnection
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class AniListRemoteService @Inject constructor(
    private val client: HttpClient
) {
    private suspend fun getMedia(id: Int) {

    }
}

@AppScope
class MediaRemoteService @Inject constructor(
    @AnilistClient
    private val client: HttpClient,
    private val dispatchers: AppDispatchers
) {
    private fun formGetMediaRequest(mediaQuery: MediaQuery): AnilistRequest {
        val requestString = makeRequestString(
            query = mediaQuery,
            response = mediaResponse,
            variables = emptyList()
        )
        val query = AnilistRequest (
            query = requestString,
            variables = ""
        )
        return query
    }

    private suspend fun getMediaWithId(id: Int): Media {
        val mediaQuery = MediaQuery(
            id = id
        )
        val query = formGetMediaRequest(mediaQuery)
        val media = withContext(dispatchers.io) {
            client.get {
                contentType(ContentType.Application.Json)
                setBody(query)
            }.body<Media>()
        }
        return media
    }
}
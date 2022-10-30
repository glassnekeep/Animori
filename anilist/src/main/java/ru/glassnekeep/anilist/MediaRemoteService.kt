package ru.glassnekeep.anilist

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.di.AnilistClient
import ru.glassnekeep.anilist.api.AnilistRequest
import ru.glassnekeep.anilist.api.MockedResponses
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.api.enums.MediaSort
import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class MediaRemoteService @Inject constructor(
    @AnilistClient
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSize: PageSizes
) {
    private val contentType = ContentType.Application.Json
    private fun formGetMediaRequest(mediaQuery: MediaQuery, pageQuery: PageQuery? = null): AnilistRequest {
        val requestString = makeRequestString(
            query = mediaQuery,
            response = MockedResponses.mediaResponse,
            variables = emptyList(),
            page = pageQuery
        )
        val query = AnilistRequest (
            query = requestString,
            variables = ""
        )
        return query
    }

    suspend fun getMedia(mediaQuery: MediaQuery): Media {
        val query = formGetMediaRequest(mediaQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getMediaList(mediaQuery: MediaQuery): List<Media> {
        val pageQuery = PageQuery(page = 1, perPage = pageSize.large)
        val query = formGetMediaRequest(mediaQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getMediaWithId(id: Int): Media {
        val mediaQuery = MediaQuery(
            id = id
        )
        val query = formGetMediaRequest(mediaQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getSortedMediaList(sort: List<MediaSort>): List<Media> {
        val mediaQuery = MediaQuery(
            sort = sort,
            type = MediaType.ANIME
        )
        val pageQuery = PageQuery(
            page = 1,
            perPage = pageSize.large
        )
        val query = formGetMediaRequest(mediaQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

}
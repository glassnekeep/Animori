package ru.glassnekeep.anilist.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.AnilistRequest
import ru.glassnekeep.anilist.api.MockedResponses
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.api.enums.MediaSort
import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.ResponseListRaw
import ru.glassnekeep.anilist.api.models.domain.mapToResponseList
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

//TODO Нужно добавить модель для возврата с Page

@AppScope
class MediaRemoteService @Inject constructor(
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSize: PageSizes,
    private val contentType: ContentType
) {
    private fun formGetMediaRequest(
        mediaQuery: MediaQuery,
        pageQuery: PageQuery? = null
    ): AnilistRequest {
        val requestString = makeRequestString(
            query = mediaQuery,
            response = MockedResponses.mediaResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = MockedResponses.emptyVariables
        )
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
            }.body<ResponseListRaw>().mapToResponseList().data.page.media ?: emptyList()
        }
    }

    suspend fun getMediaWithId(id: Int): Media {
        val mediaQuery = MediaQuery(
            id = id,
            type = MediaType.ANIME
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
package ru.glassnekeep.anilist.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.AnilistRequest
import ru.glassnekeep.anilist.api.MockedResponses
import ru.glassnekeep.anilist.api.PageSizes
import ru.glassnekeep.anilist.api.di.AnilistClient
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.studio.Studio
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.anilist.api.models.query.StudioQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class StudioRemoteService @Inject constructor(
    @AnilistClient
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSize: PageSizes,
    private val contentType: ContentType
) {
    private fun formGetStudioRequest(
        studioQuery: StudioQuery,
        pageQuery: PageQuery? = null
    ) : AnilistRequest {
        val requestString = makeRequestString(
            query = studioQuery,
            response = MockedResponses.studioResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = MockedResponses.emptyVariables
        )
    }

    suspend fun getStudio(studioQuery: StudioQuery) : Studio {
        val query = formGetStudioRequest(studioQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getStudioList(studioQuery: StudioQuery) : List<Studio> {
        val pageQuery = PageQuery(page = 1, perPage = pageSize.large)
        val query = formGetStudioRequest(studioQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }
}
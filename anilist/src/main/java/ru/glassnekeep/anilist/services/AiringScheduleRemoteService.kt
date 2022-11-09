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
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringSchedule
import ru.glassnekeep.anilist.api.models.query.AiringScheduleQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class AiringScheduleRemoteService @Inject constructor(
    @AnilistClient
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSize: PageSizes,
    private val contentType: ContentType
) {
    private fun formGetAiringScheduleRequest(
        airingScheduleQuery: AiringScheduleQuery,
        pageQuery: PageQuery? = null
    ) : AnilistRequest {
        val requestString = makeRequestString(
            query = airingScheduleQuery,
            response = MockedResponses.airingScheduleResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = ""
        )
    }

    suspend fun getAiringSchedule(airingScheduleQuery: AiringScheduleQuery) : AiringSchedule {
        val query = formGetAiringScheduleRequest(airingScheduleQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }

    suspend fun getMediaList(airingScheduleQuery: AiringScheduleQuery) : List<AiringSchedule> {
        val pageQuery = PageQuery(page = 1, perPage = pageSize.large)
        val query = formGetAiringScheduleRequest(airingScheduleQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body()
        }
    }
}
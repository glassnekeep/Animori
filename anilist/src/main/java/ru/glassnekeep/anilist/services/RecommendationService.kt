package ru.glassnekeep.anilist.services

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.*
import ru.glassnekeep.anilist.api.models.domain.ResponseListRaw
import ru.glassnekeep.anilist.api.models.domain.ResponseSingleRaw
import ru.glassnekeep.anilist.api.models.domain.mapToResponseList
import ru.glassnekeep.anilist.api.models.domain.mapToResponseSingle
import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.anilist.api.models.query.RecommendationQuery
import ru.glassnekeep.core.ContentType
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class RecommendationService @Inject constructor(
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val pageSizes: PageSizes,
    private val contentType: ContentType
) {
    private fun formGetRecommendationRequest(
        recommendationQuery: RecommendationQuery,
        pageQuery: PageQuery? = null
    ) : AnilistRequest {
        val requestString = makeRequestString(
            query = mediaQuery,
            response = MockedResponses.recommendationResponse,
            variables = emptyList(),
            page = pageQuery
        )
        return AnilistRequest(
            query = requestString,
            variables = MockedResponses.emptyVariables
        )
    }

    suspend fun getRecommendation(recommendationQuery: RecommendationQuery): Recommendation {
        val query = formGetRecommendationRequest(recommendationQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body<Recommendation>()
        }
    }

    suspend fun getRecommendationWithMediaId(mediaId: Int): Recommendation {
        val query = formGetRecommendationRequest(RecommendationQuery(id = mediaId))
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }
        }.body<ResponseSingleRaw>().mapToResponseSingle().data.recommendation!!
    }

    suspend fun getRecommentdationList(recommendationQuery: RecommendationQuery): List<Recommendation> {
        val pageQuery = PageQuery(page = 1, perPage = pageSizes.large)
        val query = formGetRecommendationRequest(recommendationQuery, pageQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body<ResponseListRaw>().mapToResponseList().data.page.recommendations ?: emptyList()
        }
    }

    suspend fun getRecommendationWithId(id: Int): Recommendation {
        val recommendationQuery = RecommendationQuery(
            id = id
        )
        val query = formGetRecommendationRequest(recommendationQuery)
        return withContext(dispatchers.io) {
            client.post {
                contentType(contentType)
                setBody(query)
            }.body<ResponseSingleRaw>().mapToResponseSingle().data.recommendation!!
        }
    }
}
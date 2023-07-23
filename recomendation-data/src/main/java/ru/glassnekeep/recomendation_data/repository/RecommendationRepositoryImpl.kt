package ru.glassnekeep.recomendation_data.repository

import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation
import ru.glassnekeep.anilist.services.RecommendationRemoteService
import javax.inject.Inject

class RecommendationRepositoryImpl @Inject constructor(
    private val recommendationRemoteService: RecommendationRemoteService
) : RecommendationRepository {
    override suspend fun getRecommendation(id: Int): Recommendation {
        return recommendationRemoteService.getRecommendationWithId(id)
    }

    override suspend fun getRecommendationWithMediaId(mediaId: Int): Recommendation {
        return recommendationRemoteService.getRecommendationWithMediaId(mediaId)
    }
}
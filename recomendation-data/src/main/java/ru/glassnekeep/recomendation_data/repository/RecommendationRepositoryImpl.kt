package ru.glassnekeep.recomendation_data.repository

import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation
import ru.glassnekeep.anilist.services.RecommendationService
import javax.inject.Inject

class RecommendationRepositoryImpl @Inject constructor(
    private val recommendationService: RecommendationService
) : RecommendationRepository {
    override suspend fun getRecommendation(id: Int): Recommendation {
        return recommendationService.getRecommendationWithId(id)
    }

    override suspend fun getRecommendationWithMediaId(mediaId: Int): Recommendation {
        return recommendationService.getRecommendationWithMediaId(mediaId)
    }
}
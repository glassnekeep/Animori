package ru.glassnekeep.recomendation_data.repository

import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation

interface RecommendationRepository {
    suspend fun getRecommendation(id: Int): Recommendation
    suspend fun getRecommendationWithMediaId(mediaId: Int): Recommendation
}
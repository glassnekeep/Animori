package ru.glassnekeep.recomendation_data

import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.recomendation_data.repository.RecommendationRepository

interface RecommendationDataProvider {
    val recommendationRepository: RecommendationRepository
    val dispatchers: AppDispatchers
}
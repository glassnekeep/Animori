package ru.glassnekeep.recomendation_data

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.recomendation_data.repository.RecommendationRepository

interface RecommendationDataProvider {
    val recommendationRepository: RecommendationRepository
    val dispatchers: AppDispatchers
}

val LocalRecommendationDataProvider = compositionLocalOf<RecommendationDataProvider> { error("No recommendation data provider found") }
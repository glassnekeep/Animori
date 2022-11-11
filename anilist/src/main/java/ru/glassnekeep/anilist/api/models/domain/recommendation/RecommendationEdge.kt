package ru.glassnekeep.anilist.api.models.domain.recommendation

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class RecommendationEdge(
    val node: Recommendation? = null
): DomainModel
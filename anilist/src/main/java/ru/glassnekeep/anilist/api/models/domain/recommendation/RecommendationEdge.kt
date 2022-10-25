package ru.glassnekeep.anilist.api.models.domain.recommendation

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class RecommendationEdge(
    val node: Recommendation? = null
): DomainModel
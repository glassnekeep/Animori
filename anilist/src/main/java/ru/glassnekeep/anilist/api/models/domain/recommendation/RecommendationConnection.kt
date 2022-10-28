package ru.glassnekeep.anilist.api.models.domain.recommendation

import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class RecommendationConnection(
    val edges: List<RecommendationEdge>? = null,
    val nodes: List<Recommendation>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
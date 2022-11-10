package ru.glassnekeep.anilist.api.models.domain.recommendation

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class RecommendationConnection(
    val edges: List<RecommendationEdge>? = null,
    val nodes: List<Recommendation>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
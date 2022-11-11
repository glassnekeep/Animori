package ru.glassnekeep.anilist.api.models.domain.review

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class ReviewConnection(
    val edges: List<ReviewEdge>? = null,
    val nodes: List<Review>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.review

import ru.glassnekeep.anilist.api.PageInfo

data class ReviewConnection(
    val edges: List<ReviewEdge>? = null,
    val nodes: List<Review>? = null,
    val pageInfo: PageInfo? = null
)
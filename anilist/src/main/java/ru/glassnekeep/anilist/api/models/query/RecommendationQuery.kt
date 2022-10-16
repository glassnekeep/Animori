package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.api.enums.RecommendationSort

data class RecommendationQuery(
    val id: Int? = null,
    val mediaId: Int? = null,
    val mediaRecommendationId: Int? = null,
    val userId: Int? = null,
    val rating: Int? = null,
    val onList: Boolean? = null,
    val rating_greater: Int? = null,
    val rating_lesser: Int? = null,
    val sort: List<RecommendationSort>? = null
)
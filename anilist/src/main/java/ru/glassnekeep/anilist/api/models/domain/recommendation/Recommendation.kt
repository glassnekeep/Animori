package ru.glassnekeep.anilist.api.models.domain.recommendation

import ru.glassnekeep.anilist.api.enums.RecommendationRating
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.user.User

data class Recommendation(
    val id: Int? = null,
    val rating: Int? = null,
    val userRating: RecommendationRating? = null,
    val media: Media? = null,
    val mediaRecommendation: Media? = null,
    val user: User? = null
): DomainModel
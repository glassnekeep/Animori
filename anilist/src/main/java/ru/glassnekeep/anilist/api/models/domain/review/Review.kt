package ru.glassnekeep.anilist.api.models.domain.review

import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.enums.ReviewRating
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.user.User

data class Review(
    val id: Int? = null,
    val userId: Int? = null,
    val mediaId: Int? = null,
    val mediaType: MediaType? = null,
    val summary: String? = null,
    val body: String? = null,
    val rating: Int? = null,
    val ratingAmount: Int? = null,
    val userRating: ReviewRating? = null,
    val score: Int? = null,
    val private: Boolean? = null,
    val siteUrl: String? = null,
    val createdAt: Int? = null,
    val updatedAt: Int? = null,
    val user: User? = null,
    val media: Media? = null
)
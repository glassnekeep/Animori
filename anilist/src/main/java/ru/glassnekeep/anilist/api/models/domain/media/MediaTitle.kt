package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable

//enum class MediaTitle {
//    romaji,
//    english,
//    native,
//    userPreferred
//}

@Serializable
data class MediaTitle(
    val romaji: String? = null,
    val english: String? = null,
    val native: String? = null,
    val userPreferred: String? = null
)
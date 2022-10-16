package ru.glassnekeep.anilist.api.models.domain.media

data class MediaTag(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val category: String? = null,
    val rank: Int? = null,
    val isGeneralSpoiler: Boolean? = null,
    val isMediaSpoiler: Boolean? = null,
    val isAdult: Boolean? = null,
    val userId: Int? = null
)
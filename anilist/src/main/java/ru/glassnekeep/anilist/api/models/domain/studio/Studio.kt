package ru.glassnekeep.anilist.api.models.domain.studio

import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection

data class Studio(
    val id: Int? = null,
    val name: String? = null,
    val isAnimationStudio: Boolean? = null,
    val media: MediaConnection? = null,
    val siteUrl: String? = null,
    val isFavourite: Boolean? = null,
    val favourites: Int? = null
)
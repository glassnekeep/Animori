package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaCoverImage(
    val extraLarge: String? = null,
    val large: String? = null,
    val medium: String? = null,
    val color: String? = null
): DomainModel
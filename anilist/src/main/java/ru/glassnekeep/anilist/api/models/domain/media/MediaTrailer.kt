package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaTrailer(
    val id: String? = null,
    val site: String? = null,
    val thumbnail: String? = null
): DomainModel
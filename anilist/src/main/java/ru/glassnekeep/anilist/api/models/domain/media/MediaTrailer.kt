package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class MediaTrailer(
    val id: String? = null,
    val site: String? = null,
    val thumbnail: String? = null
): DomainModel
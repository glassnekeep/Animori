package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class MediaStreamingEpisode(
    val title: String? = null,
    val thumbnail: String? = null,
    val url: String? = null,
    val site: String? = null
): DomainModel
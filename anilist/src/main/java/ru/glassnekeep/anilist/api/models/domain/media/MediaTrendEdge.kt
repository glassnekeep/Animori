package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class MediaTrendEdge(
    val node: MediaTrend? = null
): DomainModel
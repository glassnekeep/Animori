package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class MediaTrendConnection(
    val edges: List<MediaTrendEdge>? = null,
    val nodes: List<MediaTrend>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaTrendConnection(
    val edges: List<MediaTrendEdge>? = null,
    val nodes: List<MediaTrend>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.studio

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StudioConnection(
    val edges: List<StudioEdge>? = null,
    val nodes: List<Studio>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
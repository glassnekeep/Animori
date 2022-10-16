package ru.glassnekeep.anilist.api.models.domain.studio

import ru.glassnekeep.anilist.api.PageInfo

data class StudioConnection(
    val edges: List<StudioEdge>? = null,
    val nodes: List<Studio>? = null,
    val pageInfo: PageInfo? = null
)
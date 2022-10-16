package ru.glassnekeep.anilist.api.models.domain.staff

import ru.glassnekeep.anilist.api.PageInfo

data class StaffConnection(
    val edges: List<StaffEdge>? = null,
    val nodes: List<Staff>? = null,
    val pageInfo: PageInfo? = null
)
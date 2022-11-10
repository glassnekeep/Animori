package ru.glassnekeep.anilist.api.models.domain.staff

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StaffConnection(
    val edges: List<StaffEdge>? = null,
    val nodes: List<Staff>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.staff

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StaffEdge(
    val node: Staff? = null,
    val id: Int? = null,
    val role: String? = null,
    val favouriteOrder: Int? = null
): DomainModel
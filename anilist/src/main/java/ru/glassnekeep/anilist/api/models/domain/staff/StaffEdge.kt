package ru.glassnekeep.anilist.api.models.domain.staff

data class StaffEdge(
    val node: Staff? = null,
    val id: Int? = null,
    val role: String? = null,
    val favouriteOrder: Int? = null
)
package ru.glassnekeep.anilist.api.models.domain.staff

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StaffImage(
    val large: String? = null,
    val medium: String? = null
): DomainModel
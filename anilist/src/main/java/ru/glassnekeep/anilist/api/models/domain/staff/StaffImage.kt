package ru.glassnekeep.anilist.api.models.domain.staff

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class StaffImage(
    val large: String? = null,
    val medium: String? = null
): DomainModel
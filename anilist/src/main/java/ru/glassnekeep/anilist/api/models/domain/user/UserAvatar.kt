package ru.glassnekeep.anilist.api.models.domain.user

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class UserAvatar(
    val large: String? = null,
    val medium: String? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.user

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class UserPreviousName(
    val name: String? = null,
    val createdAt: Int? = null,
    val updatedAt: Int? = null
): DomainModel
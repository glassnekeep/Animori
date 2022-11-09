package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class UserPreviousName(
    val name: String? = null,
    val createdAt: Int? = null,
    val updatedAt: Int? = null
): DomainModel
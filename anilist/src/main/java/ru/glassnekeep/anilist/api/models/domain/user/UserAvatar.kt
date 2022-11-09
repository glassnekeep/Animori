package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class UserAvatar(
    val large: String? = null,
    val medium: String? = null
): DomainModel
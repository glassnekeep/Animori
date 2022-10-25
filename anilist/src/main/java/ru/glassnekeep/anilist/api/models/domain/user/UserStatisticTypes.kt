package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class UserStatisticTypes(
    val anime: UserStatistics? = null,
    val manga: UserStatistics? = null
): DomainModel
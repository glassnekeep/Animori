package ru.glassnekeep.anilist.api.models.domain.user

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class UserStatisticTypes(
    val anime: UserStatistics? = null,
    val manga: UserStatistics? = null
): DomainModel
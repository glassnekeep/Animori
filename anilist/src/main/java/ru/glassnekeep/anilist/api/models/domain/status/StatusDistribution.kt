package ru.glassnekeep.anilist.api.models.domain.status

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaListStatus
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StatusDistribution(
    val status: MediaListStatus? = null,
    val amount: Int? = null
): DomainModel
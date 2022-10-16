package ru.glassnekeep.anilist.api.models.domain.status

import ru.glassnekeep.anilist.api.enums.MediaListStatus

data class StatusDistribution(
    val status: MediaListStatus? = null,
    val amount: Int? = null
)
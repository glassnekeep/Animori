package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaListStatus

@Serializable
data class ListActivityOption(
    val disabled: Boolean? = null,
    val type: MediaListStatus? = null
)
package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.MediaListStatus

data class ListActivityOption(
    val disabled: Boolean? = null,
    val type: MediaListStatus? = null
)
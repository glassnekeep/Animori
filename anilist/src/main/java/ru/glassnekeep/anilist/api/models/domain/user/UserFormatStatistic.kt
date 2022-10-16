package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.enums.MediaFormat

data class UserFormatStatistic(
    val count: Int? = null,
    val meanScore: Float? = null,
    val minutesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val mediaIds: List<Int>? = null,
    val format: MediaFormat? = null
)
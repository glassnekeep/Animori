package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.enums.MediaListStatus

data class UserStatusStatistic(
    val count: Int? = null,
    val meanScore: Float? = null,
    val minutesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val mediaIds: List<Int>? = null,
    val status: MediaListStatus? = null
)
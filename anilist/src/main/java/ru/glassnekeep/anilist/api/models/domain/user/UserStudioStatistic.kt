package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.models.domain.studio.Studio

data class UserStudioStatistic(
    val count: Int? = null,
    val meanScore: Float? = null,
    val minutesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val mediaIds: List<Int>? = null,
    val studio: Studio? = null
)
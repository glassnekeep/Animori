package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.MediaTag

data class UserTagStatistic(
    val count: Int? = null,
    val meanScore: Float? = null,
    val minutesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val mediaIds: List<Int>? = null,
    val tag: MediaTag? = null
): DomainModel
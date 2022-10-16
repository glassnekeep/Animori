package ru.glassnekeep.anilist.api.models.domain.user

data class UserStartYearStatistic(
    val count: Int? = null,
    val meanScore: Float? = null,
    val minutesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val mediaIds: List<Int>? = null,
    val startYear: Int? = null
)
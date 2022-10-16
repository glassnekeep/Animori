package ru.glassnekeep.anilist.api.models.domain.schedule

import ru.glassnekeep.anilist.api.models.domain.media.Media

data class AiringSchedule(
    val id: Int? = null,
    val airingAt: Int? = null,
    val timeUntilAiring: Int? = null,
    val episode: Int? = null,
    val mediaId: Int? = null,
    val media: Media? = null
)
package ru.glassnekeep.anilist.api.models.domain.schedule

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.Media

@Serializable
data class AiringSchedule(
    val id: Int? = null,
    val airingAt: Int? = null,
    val timeUntilAiring: Int? = null,
    val episode: Int? = null,
    val mediaId: Int? = null,
    val media: Media? = null
): DomainModel
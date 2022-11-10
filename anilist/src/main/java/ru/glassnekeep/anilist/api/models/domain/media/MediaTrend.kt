package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaTrend(
    val mediaId: Int? = null,
    val date: Int? = null,
    val trending: Int? = null,
    val averageScore: Int? = null,
    val popularity: Int? = null,
    val inProgress: Int? = null,
    val releasing: Boolean? = null,
    val episode: Int? = null,
    val media: Media? = null
): DomainModel
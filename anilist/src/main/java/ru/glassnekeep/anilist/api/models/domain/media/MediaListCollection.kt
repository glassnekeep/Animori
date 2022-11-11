package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.user.User

@Serializable
data class MediaListCollection(
    val lists: List<MediaListGroup>? = null,
    val user: User? = null,
    val hasNextChunk: Boolean? = null
): DomainModel
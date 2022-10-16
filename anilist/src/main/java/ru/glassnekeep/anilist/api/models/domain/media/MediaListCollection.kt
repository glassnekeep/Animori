package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.user.User

data class MediaListCollection(
    val lists: List<MediaListGroup>? = null,
    val user: User? = null,
    val hasNextChunk: Boolean? = null
)
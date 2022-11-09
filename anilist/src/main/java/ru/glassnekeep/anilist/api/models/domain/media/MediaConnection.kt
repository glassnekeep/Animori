package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class MediaConnection(
    val edges: MediaEdge? = null
): DomainModel
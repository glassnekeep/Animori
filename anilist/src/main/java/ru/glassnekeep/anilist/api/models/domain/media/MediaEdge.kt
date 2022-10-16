package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.enums.MediaRelation
import ru.glassnekeep.anilist.api.models.domain.character.Character

data class MediaEdge(
    val node: Media? = null,
    val id: Int? = null,
    val relationType: MediaRelation? = null,
    val isMainStudio: Boolean? = null,
    val characters: List<Character>? = null
)
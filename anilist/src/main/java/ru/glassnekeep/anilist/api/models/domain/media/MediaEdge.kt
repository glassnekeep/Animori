package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaRelation
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.character.Character

@Serializable
data class MediaEdge(
    val node: Media? = null,
    val id: Int? = null,
    val relationType: MediaRelation? = null,
    val isMainStudio: Boolean? = null,
    val characters: List<Character>? = null
): DomainModel
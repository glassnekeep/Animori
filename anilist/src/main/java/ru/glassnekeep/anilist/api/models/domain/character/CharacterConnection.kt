package ru.glassnekeep.anilist.api.models.domain.character

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class CharacterConnection(
    val edges: List<CharacterEdge>? = null,
    val nodes: List<Character>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
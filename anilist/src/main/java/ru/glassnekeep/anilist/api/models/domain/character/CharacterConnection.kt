package ru.glassnekeep.anilist.api.models.domain.character

import ru.glassnekeep.anilist.api.PageInfo

data class CharacterConnection(
    val edges: List<CharacterEdge>? = null,
    val nodes: List<Character>? = null,
    val pageInfo: PageInfo? = null
)
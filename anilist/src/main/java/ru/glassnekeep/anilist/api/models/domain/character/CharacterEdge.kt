package ru.glassnekeep.anilist.api.models.domain.character

import ru.glassnekeep.anilist.api.models.domain.staff.Staff
import ru.glassnekeep.anilist.api.enums.CharacterRole

data class CharacterEdge(
    val id: Int? = null,
    val role: CharacterRole? = null,
    val name: String? = null,
    val voiceActors: List<Staff>? = null
)
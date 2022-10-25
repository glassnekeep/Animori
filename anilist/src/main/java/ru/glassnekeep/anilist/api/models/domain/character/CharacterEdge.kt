package ru.glassnekeep.anilist.api.models.domain.character

import ru.glassnekeep.anilist.api.models.domain.staff.Staff
import ru.glassnekeep.anilist.api.enums.CharacterRole
import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class CharacterEdge(
    val id: Int? = null,
    val role: CharacterRole? = null,
    val name: String? = null,
    val voiceActors: List<Staff>? = null
): DomainModel
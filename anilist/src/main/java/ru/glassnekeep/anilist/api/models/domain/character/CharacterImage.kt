package ru.glassnekeep.anilist.api.models.domain.character

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class CharacterImage(
    val large: String? = null,
    val medium: String? = null
): DomainModel
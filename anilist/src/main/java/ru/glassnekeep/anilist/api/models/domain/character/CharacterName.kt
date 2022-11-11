package ru.glassnekeep.anilist.api.models.domain.character

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class CharacterName(
    val first: String? = null,
    val middle: String? = null,
    val last: String? = null,
    val full: String? = null,
    val native: String? = null,
    val alternative: List<String>? = null,
    val alternativeSpoiler: List<String>? = null,
    val userPreferred: String? = null
): DomainModel
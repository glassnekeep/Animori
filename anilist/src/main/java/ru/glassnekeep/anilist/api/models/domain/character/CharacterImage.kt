package ru.glassnekeep.anilist.api.models.domain.character

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class CharacterImage(
    val large: String? = null,
    val medium: String? = null
): DomainModel
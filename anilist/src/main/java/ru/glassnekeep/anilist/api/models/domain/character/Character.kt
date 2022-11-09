package ru.glassnekeep.anilist.api.models.domain.character

import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection

data class Character(
    val id: Int? = null,
    val name: CharacterName? = null,
    val image: CharacterImage? = null,
    val description: String? = null,
    val gender: String? = null,
    val dateOfBirth: FuzzyDate? = null,
    val age: String? = null,
    val bloodType: String? = null,
    val isFavourite: Boolean? = null,
    val isFavouriteBlocked: Boolean? = null,
    val siteUrl: String? = null,
    val media: MediaConnection? = null,
    val favourites: Int? = null,
    val modNotes: String? = null
): DomainModel
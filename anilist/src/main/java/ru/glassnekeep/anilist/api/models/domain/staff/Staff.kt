package ru.glassnekeep.anilist.api.models.domain.staff

import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.character.CharacterConnection
import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection
import ru.glassnekeep.anilist.api.models.domain.user.User

data class Staff(
    val id: Int? = null,
    val name: StaffName? = null,
    val languageV2: String? = null,
    val image: StaffImage? = null,
    val description: String? = null,
    val primaryOccupations: List<String>? = null,
    val gender: String? = null,
    val dateOfBirth: FuzzyDate? = null,
    val dateOfDeath: FuzzyDate? = null,
    val age: Int? = null,
    val yearsActive: List<Int>? = null,
    val homeTown: String? = null,
    val bloodType: String? = null,
    val isFavourite: Boolean? = null,
    val isFavouriteBlocked: Boolean? = null,
    val siteUrl: String? = null,
    val staffMedia: MediaConnection? = null,
    val characters: CharacterConnection? = null,
    val characterMedia: MediaConnection? = null,
    val staff: Staff? = null,
    val submitter: User? = null,
    val submissionStatus: Int? = null,
    val submissionNotes: String? = null,
    val favourites: Int? = null,
    val modNotes: String? = null
): DomainModel
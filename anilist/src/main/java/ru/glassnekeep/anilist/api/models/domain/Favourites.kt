package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.character.CharacterConnection
import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection
import ru.glassnekeep.anilist.api.models.domain.staff.StaffConnection
import ru.glassnekeep.anilist.api.models.domain.studio.StudioConnection

@Serializable
data class Favourites(
    val anime: MediaConnection? = null,
    val manga: MediaConnection? = null,
    val characters: CharacterConnection? = null,
    val staff: StaffConnection? = null,
    val studios: StudioConnection? = null
)
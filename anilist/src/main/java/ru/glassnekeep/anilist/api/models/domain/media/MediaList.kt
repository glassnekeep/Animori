package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.json.Json
import ru.glassnekeep.anilist.api.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.user.User
import ru.glassnekeep.anilist.api.enums.MediaListStatus

data class MediaList(
    val id: Int? = null,
    val userId: Int? = null,
    val mediaId: Int? = null,
    val status: MediaListStatus? = null,
    val score: Float? = null,
    val progress: Int? = null,
    val progressVolumes: Int? = null,
    val repeat: Int? = null,
    val priority: Int? = null,
    val private: Boolean? = null,
    val notes: String? = null,
    val hiddenFromStatusLists: Boolean? = null,
    val customLists: Json? = null,
    val advancedScores: Json? = null,
    val startedAt: FuzzyDate? = null,
    val completedAt: FuzzyDate? = null,
    val updatedAt: Int? = null,
    val createdAt: Int? = null,
    val media: Media? = null,
    val user: User? = null
)
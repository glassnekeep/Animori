package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.user.User
import ru.glassnekeep.anilist.api.enums.MediaListStatus
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
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
    //Json here in case of docs
    val customLists: String? = null,
    //Json here in case of docs
    val advancedScores: String? = null,
    val startedAt: FuzzyDate? = null,
    val completedAt: FuzzyDate? = null,
    val updatedAt: Int? = null,
    val createdAt: Int? = null,
    val media: Media? = null,
    val user: User? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.api.enums.MediaListSort
import ru.glassnekeep.anilist.api.enums.MediaListStatus
import ru.glassnekeep.anilist.api.enums.MediaType

data class MediaListQuery(
    val id: Int? = null,
    val userId: Int? = null,
    val userName: String? = null,
    val type: MediaType? = null,
    val status: MediaListStatus? = null,
    val mediaId: Int? = null,
    val isFollowing: Boolean? = null,
    val notes: String? = null,
    val startedAt: Long? = null,
    val completedAt: Long? = null,
    val compareWithAuthList: Boolean? = null,
    val userId_in: List<Int>? = null,
    val status_in: List<MediaListStatus>? = null,
    val status_not_in: List<MediaListStatus>? = null,
    val status_not: MediaListStatus? = null,
    val mediaId_in: List<Int>? = null,
    val mediaId_not_in: List<Int>? = null,
    val notes_like: String? = null,
    val startedAt_greater: Long? = null,
    val startedAt_lesser: Long? = null,
    val startedAt_like: String? = null,
    val completedAt_greater: Long? = null,
    val completedAt_lesser: Long? = null,
    val completedAt_like: String? = null,
    val sort: List<MediaListSort>? = null
) : QueryParameter
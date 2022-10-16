package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.enums.MediaListStatus

data class MediaListGroup(
    val entries: List<MediaList>? = null,
    val name: String? = null,
    val isCustomList: Boolean? = null,
    val isSplitCompletedList: Boolean? = null,
    val status: MediaListStatus? = null
)
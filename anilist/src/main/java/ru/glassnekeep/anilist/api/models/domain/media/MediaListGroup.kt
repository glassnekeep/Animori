package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaListStatus
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaListGroup(
    val entries: List<MediaList>? = null,
    val name: String? = null,
    val isCustomList: Boolean? = null,
    val isSplitCompletedList: Boolean? = null,
    val status: MediaListStatus? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaFormat
import ru.glassnekeep.anilist.api.enums.MediaRankType
import ru.glassnekeep.anilist.api.enums.MediaSeason
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaRank(
    val id: Int? = null,
    val rank: Int? = null,
    val type: MediaRankType? = null,
    val format: MediaFormat? = null,
    val year: Int? = null,
    val season: MediaSeason? = null,
    val allTime: Boolean? = null,
    val context: String? = null
): DomainModel
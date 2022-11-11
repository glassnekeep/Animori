package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.ScoreFormat
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaListOptions(
    val scoreFormat: ScoreFormat? = null,
    val rowOrder: String? = null,
    val animeList: MediaListTypeOptions? = null,
    val mangaList: MediaListTypeOptions? = null
): DomainModel
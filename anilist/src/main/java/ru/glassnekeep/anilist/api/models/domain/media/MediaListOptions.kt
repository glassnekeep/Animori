package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.enums.ScoreFormat

data class MediaListOptions(
    val scoreFormat: ScoreFormat? = null,
    val rowOrder: String? = null,
    val animeList: MediaListTypeOptions? = null,
    val mangaList: MediaListTypeOptions? = null
)
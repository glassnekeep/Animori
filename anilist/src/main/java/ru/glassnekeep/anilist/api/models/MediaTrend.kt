package ru.glassnekeep.anilist.api.models

import ru.glassnekeep.anilist.QueryParameter
import ru.glassnekeep.anilist.api.enums.MediaTrendSort

data class MediaTrend(
    val mediaId: Int? = null,
    val date: Int? = null,
    val trending: Int? = null,
    val averageScore: Int? = null,
    val popularity: Int? = null,
    val episode: Int? = null,
    val releasing: Boolean? = null,
    val mediaId_not: Int? = null,
    val mediaId_in: List<Int>? = null,
    val date_greater: Int? = null,
    val mediaId_not_in: List<Int>? = null,
    val date_lesser: Int? = null,
    val trending_greater: Int? = null,
    val trending_lesser: Int? = null,
    val trending_not: Int? = null,
    val averageScore_greater: Int? = null,
    val averageScore_lesser: Int? = null,
    val averageScore_not: Int? = null,
    val popularity_greater: Int? = null,
    val popularity_lesser: Int? = null,
    val popularity_not: Int? = null,
    val episode_greater: Int? = null,
    val episode_lesser: Int? = null,
    val episode_not: Int? = null,
    val sort: List<MediaTrendSort>? = null
) : QueryParameter
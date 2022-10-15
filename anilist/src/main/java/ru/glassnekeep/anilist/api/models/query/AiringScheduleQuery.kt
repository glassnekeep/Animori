package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.QueryParameter
import ru.glassnekeep.anilist.api.enums.AiringSort

data class AiringScheduleQuery(
    val id: Int? = null,
    val mediaId: Int? = null,
    val episode: Int? = null,
    val airingAt: Int? = null,
    val notYetAired: Boolean? = null,
    val id_not: Int? = null,
    val id_in: List<Int>? = null,
    val id_not_in: List<Int>? = null,
    val mediaId_not: Int? = null,
    val mediaId_in: List<Int>? = null,
    val mediaId_not_in: List<Int>? = null,
    val episode_not: Int? = null,
    val episode_in: List<Int>? = null,
    val episode_not_in: List<Int>? = null,
    val episode_greater: Int? = null,
    val episode_lesser: Int? = null,
    val airingAt_greater: Int? = null,
    val airingAt_lesser: Int? = null,
    val sort: List<AiringSort>? = null
) : QueryParameter
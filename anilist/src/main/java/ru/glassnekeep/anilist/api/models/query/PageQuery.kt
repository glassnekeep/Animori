package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.QueryParameter

data class PageQuery(
    val page: Int? = null,
    val perPage: Int? = null
) : QueryParameter
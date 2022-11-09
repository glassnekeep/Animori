package ru.glassnekeep.anilist.api.models.query

data class PageQuery(
    val page: Int? = null,
    val perPage: Int? = null
) : QueryParameter
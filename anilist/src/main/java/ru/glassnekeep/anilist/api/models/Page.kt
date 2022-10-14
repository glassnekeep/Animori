package ru.glassnekeep.anilist.api.models

import ru.glassnekeep.anilist.QueryParameter

data class Page(
    val page: Int? = null,
    val perPage: Int? = null
) : QueryParameter
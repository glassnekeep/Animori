package ru.glassnekeep.anilist.api.models

import ru.glassnekeep.anilist.QueryParameter

data class PopularAnimeListRequest(
    val query: String,
    val variables: String
) : QueryParameter


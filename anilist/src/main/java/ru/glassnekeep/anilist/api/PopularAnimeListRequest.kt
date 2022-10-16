package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.query.MediaQuery

data class PopularAnimeListRequest(
    val query: String,
    val variables: String
)

val mediaQuery = MediaQuery(
    id = 15355,
    type = MediaType.ANIME
)

fun make(mediaQuery: MediaQuery, title: String, variables: List<String>) {
    var string = mediaQuery.toString().replace(Regex("List<a-zA-Z>+=null,? ?"), "")
    //string = string.replace()
}



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
    //var string = mediaQuery.toString().replace(Regex("List<a-zA-Z>+=null,? ?"), "")
    var string = mediaQuery.toString()
        .replace(Regex("[a-zA-Z]+=null,? ?"), "")
        .replace(", )", ")")
        .replace(Regex("=[0-9a-zA-Z]+,?"), "\n")
        .replace("(", " {\n ")
}

fun basicMediaRequest(mediaQuery: MediaQuery) {
    var string = mediaQuery.toString()
}

package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.QueryParameter

data class PopularAnimeListRequest(
    val query: String,
    val variables: String
)

val mediaQuery = MediaQuery(
    id = 15355,
    type = MediaType.ANIME
)

fun makeRequestString(query: QueryParameter, response: DomainModel, variables: List<String>): String {
    //var string = mediaQuery.toString().replace(Regex("List<a-zA-Z>+=null,? ?"), "")
    val responseString = response.toString()
        .replace(Regex("[a-zA-Z]+=null,? ?"), "")
        .replace(", )", ")")
        .replace(Regex("=[0-9a-zA-Z]+,?"), "\n")
        .replace("(", " {\n ")
        .replace(Regex("[a-zA-Z]+ \\{"), "{")
    val variableString = buildString {
        for (variable in variables) {
            append("\$$variable, ")
        }
        removeSuffix(", ")
    }
    val queryString = buildString {
        if (variables.isNotEmpty()) {
            append("query (")
            append(variableString)
            append(")")
        } else {
            append("query")
        }
    }
    val parameterString = query.toString()
        .replace(Regex("[a-zA-Z]+=null,? ?"), "")
        .replace(Regex("[a-zA-Z]+\\("), "${response.toString().substringBefore("(")} (")
        .replace("(", " (")
        .replace("=", ": $")
    val requestString = buildString {
        append(queryString, "{\n", parameterString, responseString, "\n}")
    }
    return requestString
}

fun basicMediaRequest(mediaQuery: MediaQuery) {
    var string = mediaQuery.toString()
}

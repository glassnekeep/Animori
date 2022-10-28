package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.QueryParameter

data class AnilistRequest(
    val query: String,
    val variables: String
)

val mediaQuery = MediaQuery(
    id = 15355,
    type = MediaType.ANIME
)

fun makeRequestString(query: QueryParameter, response: DomainModel, variables: List<String>): String {
    //var string = mediaQuery.toString().replace(Regex("List<a-zA-Z>+=null,? ?"), "")
    var responseString = response.toString()
        .replace(Regex("[a-zA-Z]+=null,? ?"), "")
        .replace(", )", ")")
        .replace(Regex("=[0-9a-zA-Z]+,? ?"), "\n\t\t")
        .replace("(", " {\n\t\t")
        .replace(")", "}")
        .replace(Regex("[a-zA-Z]+ \\{"), "{")
        .replace("\t}", "}")
    if (response is Media) {
        if (response.title != null) {
            responseString = responseString.replace("title", "title {\n\t\t\tenglish\n\t\t}")
        }
    }
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
        .replace(Regex("[a-zA-Z_]+=null,? ?"), "")
        .replace(Regex("[a-zA-Z]+\\("), "${response.toString().substringBefore("(")} (")
        .replace("(", " (")
        .replace("=", ": ")
        .replace(", )", ") ")
        //.replace(Regex("[a-zA-Z]+: \\\$null, "), "")
    val array = Array<Array<Int>>(50) { Array(50, { 0 }) }
    array.forEachIndexed { index, ints ->
        ints.forEachIndexed { index1, i ->
            index + index1 + i
        }
    }
    val requestString = buildString {
        append(queryString, " {\n\t", parameterString, responseString, "\n}")
    }
    return requestString
}

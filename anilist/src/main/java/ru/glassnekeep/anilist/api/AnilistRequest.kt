package ru.glassnekeep.anilist.api

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.anilist.api.models.query.QueryParameter

@Serializable
class Test

@Serializable
data class AnilistRequest(
    val query: String,
    val variables: Test
)

val mediaQuery = MediaQuery(
    id = 15355,
    type = MediaType.ANIME
)

fun makeRequestString(
    query: QueryParameter,
    response: DomainModel,
    variables: List<String>,
    page: PageQuery? = null
): String {
    val queryString = formQueryString(variables)
    val pageString = formPageString(page)
    val parametersString = formParametersString(query, page, response)
    val responseString = formResponseString(response)
    return formRequestString(queryString, pageString, parametersString, responseString, page)
}

fun formQueryString(variables: List<String>): String {
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
    return queryString
}

fun formPageString(page: PageQuery? = null): String {
    return if (page != null) {
        buildString {
            append(
                page.toString()
                    .replace(Regex("[a-zA-Z_]+=null,? ?"), "")
                    .replace(Regex("[a-zA-Z]+\\("), "Page (")
                    .replace("(", " (")
                    .replace("=", ": ")
                    .replace(", )", ") ")
            )
            append(" {")
        }
    } else {
        ""
    }
}

fun formParametersString(
    query: QueryParameter,
    page: PageQuery? = null,
    response: DomainModel
): String {
    var parameterString = query.toString()
        .replace(Regex("[a-zA-Z_]+=null,? ?"), "")
        .replace(Regex("[a-zA-Z]+\\("), "${response.toString().substringBefore("(")} (")
        .replace("(", " (")
        .replace("=", ": ")
        .replace(", )", ") ")
    if (page != null) {
        parameterString = parameterString.replaceFirstChar { it.lowercaseChar() }
    }
    return parameterString
}

fun formResponseString(response: DomainModel): String {
    return response.toString()
        .replaceFirst(Regex("[a-zA-Z]+\\("), "{")
        .replace(Regex("=\\[[a-zA-Z]+\\("), "{")
        .replace(Regex("[a-zA-Z]+=null,? ?"), "")
        .replace(", )", ")")
        .replace(Regex("=[0-9a-zA-Z ]+,? ?"), " ")
        .replace(Regex("[a-zA-Z]+ \\{"), "{")
        .replace("(", " {")
        .replace(")", "}")
        .replace("}", "}")
}

fun formRequestString(
    queryString: String,
    pageString: String,
    parametersString: String,
    responseString: String,
    page: PageQuery? = null
): String {
    return buildString {
        append(queryString, " {", pageString, parametersString, responseString, "}")
        if (page != null) append("}")
    }
        .replace(Regex("=\\[]"), "")
        .replace(Regex(","), "")
        .replace(Regex("\\]"), "")
        //.replace(Regex("\\{\\}"), "{ edges  { id }}")
}

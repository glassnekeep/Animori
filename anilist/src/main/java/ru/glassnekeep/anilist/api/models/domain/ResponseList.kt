package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.exceptions.ParsingException
import ru.glassnekeep.anilist.api.models.domain.exceptions.TooManyRequestsException

@Serializable
data class ResponseListRaw(
    val data: Data? = null,
    val errors: List<Error>? = null
)

fun ResponseListRaw.mapToResponseList(): ResponseList {
    if (errors != null) {
        val error = errors.first()
        val message = error.message
        throw when (error.status) {
            429 -> {
                TooManyRequestsException(message)
            }
            else -> { ParsingException(message) }
        }
    }
    if (data != null) return ResponseList(data) else throw ParsingException("No data passed on successful request")
}

@Serializable
data class ResponseList(
    val data: Data
)

@Serializable
data class Data(
    @SerialName("Page") val page: Page,
)

@Serializable
data class Error(
    val message: String,
    val status: Int
)
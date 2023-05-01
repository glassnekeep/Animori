package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.exceptions.ParsingException
import ru.glassnekeep.anilist.api.models.domain.exceptions.TooManyRequestsException
import ru.glassnekeep.anilist.api.models.domain.media.Media

@Serializable
data class ResponseSingleRaw(
    val data: DataSingle? = null,
    val errors: List<Error>? = null,
)

fun ResponseSingleRaw.mapToResponseSingle(): ResponseSingle {
    if (errors != null) {
        val error = errors.first()
        val message = error.message
        throw when (error.status) {
            429 -> { TooManyRequestsException(message) }
            else -> { ParsingException(message) }
        }
    }
    if (data != null) return ResponseSingle(data) else throw ParsingException("No data passed on successful request")
}

@Serializable
data class ResponseSingle(
    @SerialName("data") val data: DataSingle
)

@Serializable
data class DataSingle(
    @SerialName("Media") val media: Media,
)
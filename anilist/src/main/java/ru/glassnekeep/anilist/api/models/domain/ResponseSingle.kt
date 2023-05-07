package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.api.models.domain.exceptions.ParsingException
import ru.glassnekeep.anilist.api.models.domain.exceptions.TooManyRequestsException
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringSchedule
import ru.glassnekeep.anilist.api.models.domain.studio.Studio

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
    @SerialName("Media") val media: Media? = null,
    @SerialName("AiringSchedule") val schedule: AiringSchedule? = null,
    @SerialName("Recommendation") val recommendation: Recommendation? = null,
    @SerialName("Character") val character: Character? = null,
    @SerialName("Studio") val studio: Studio? = null,
)
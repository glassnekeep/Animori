package ru.glassnekeep.user_data.models

import kotlinx.serialization.Serializable
import ru.glassnekeep.user_data.models.enums.MediaStatus
import ru.glassnekeep.user_data.models.enums.MediaType

@Serializable
data class Media(
    val id: Int,
    val title: String,
    val type: MediaType,
    val status: MediaStatus
)
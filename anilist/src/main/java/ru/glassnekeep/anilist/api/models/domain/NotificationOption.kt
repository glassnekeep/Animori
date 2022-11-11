package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.NotificationType

@Serializable
data class NotificationOption(
    val type: NotificationType? = null,
    val enabled: Boolean? = null
)
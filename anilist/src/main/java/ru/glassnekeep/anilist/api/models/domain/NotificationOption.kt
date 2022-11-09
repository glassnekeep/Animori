package ru.glassnekeep.anilist.api.models.domain

import ru.glassnekeep.anilist.api.enums.NotificationType

data class NotificationOption(
    val type: NotificationType? = null,
    val enabled: Boolean? = null
)
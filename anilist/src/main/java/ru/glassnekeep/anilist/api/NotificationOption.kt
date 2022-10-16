package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.NotificationType

data class NotificationOption(
    val type: NotificationType? = null,
    val enabled: Boolean? = null
)
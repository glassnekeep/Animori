package ru.glassnekeep.anilist.api.models.domain.user

import ru.glassnekeep.anilist.api.ListActivityOption
import ru.glassnekeep.anilist.api.NotificationOption
import ru.glassnekeep.anilist.api.enums.UserStaffNameLanguage
import ru.glassnekeep.anilist.api.enums.UserTitleLanguage

data class UserOptions(
    val titleLanguage: UserTitleLanguage? = null,
    val displayAdultContent: Boolean? = null,
    val airingNotifications: Boolean? = null,
    val profileColor: String? = null,
    val notificationOptions: List<NotificationOption>? = null,
    val timezone: String? = null,
    val activityMergeTime: Int? = null,
    val staffNameLanguage: UserStaffNameLanguage? = null,
    val restrictMessagesToFollowing: Boolean? = null,
    val disabledListActivity: List<ListActivityOption>? = null
)
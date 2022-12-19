package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.media.MediaList
import ru.glassnekeep.anilist.api.models.domain.media.MediaTrend
import ru.glassnekeep.anilist.api.models.domain.recommendation.Recommendation
import ru.glassnekeep.anilist.api.models.domain.review.Review
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringSchedule
import ru.glassnekeep.anilist.api.models.domain.staff.Staff
import ru.glassnekeep.anilist.api.models.domain.studio.Studio
import ru.glassnekeep.anilist.api.models.domain.user.User

/** Тут нужно создать новые модельки и раскомментить **/

@Serializable
data class Page(
    val pageInfo: PageInfo? = null,
    val users: List<User>? = null,
    val media: List<Media>? = null,
    val characters: List<Character>? = null,
    val staff: List<Staff>? = null,
    val studios: List<Studio>? = null,
    val mediaList: List<MediaList>? = null,
    val airingSchedules: List<AiringSchedule>? = null,
    val mediaTrends: List<MediaTrend>? = null,
    //val notifications: List<NotificationUnion>? = null,
    val followers: List<User>? = null,
    val following: List<User>? = null,
    //val activities: List<ActivityUnion>? = null,
    //val activityReplies: List<ActivityReply>? = null,
    //val threads: List<Thread>? = null,
    //val threadComments: List<ThreadComment>? = null,
    val reviews: List<Review>? = null,
    val recommendations: List<Recommendation>? = null,
    val likes: List<User>? = null,
)

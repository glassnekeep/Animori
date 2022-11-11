package ru.glassnekeep.anilist.api.models.domain.user

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class UserStatistics(
    val count: Int? = null,
    val meanScore: Float? = null,
    val standardDeviation: Float? = null,
    val minutesWatched: Int? = null,
    val episodesWatched: Int? = null,
    val chaptersRead: Int? = null,
    val volumesRead: Int? = null,
    val formats: List<UserFormatStatistic>? = null,
    val statuses: List<UserStatusStatistic>? = null,
    val scores: List<UserScoreStatistic>? = null,
    val lengths: List<UserLengthStatistic>? = null,
    val releaseYears: List<UserReleaseYearStatistic>? = null,
    val startYears: List<UserStartYearStatistic>? = null,
    val genres: List<UserGenreStatistic>? = null,
    val tags: List<UserTagStatistic>? = null,
    val countries: List<UserCountryStatistic>? = null,
    val voiceActors: List<UserVoiceActorStatistic>? = null,
    val staff: List<UserStaffStatistic>? = null,
    val studios: List<UserStudioStatistic>? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.*
import ru.glassnekeep.anilist.api.enums.*
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.character.CharacterConnection
import ru.glassnekeep.anilist.api.models.domain.recommendation.RecommendationConnection
import ru.glassnekeep.anilist.api.models.domain.review.ReviewConnection
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringSchedule
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringScheduleConnection
import ru.glassnekeep.anilist.api.models.domain.staff.StaffConnection
import ru.glassnekeep.anilist.api.models.domain.studio.StudioConnection

data class Media(
    val id: Int? = null,
    val idMal: Int? = null,
    val title: MediaTitle? = null,
    val type: MediaType? = null,
    val format: MediaFormat? = null,
    val status: MediaStatus? = null,
    val description: String? = null,
    val startDate: FuzzyDate? = null,
    val endDate: FuzzyDate? = null,
    val season: MediaSeason? = null,
    val seasonYear: Int? = null,
    val seasonInt: Int? = null,
    val episodes: Int? = null,
    val duration: Int? = null,
    val chapters: Int? = null,
    val volumes: Int? = null,
    val countryOfOrigin: String? = null,
    val isLicensed: Boolean? = null,
    val source: MediaSource? = null,
    val hashtag: String? = null,
    val trailer: MediaTrailer? = null,
    val updatedAt: Int? = null,
    val coverImage: MediaCoverImage? = null,
    val bannerImage: String? = null,
    val genres: List<String>? = null,
    val synonyms: List<String>? = null,
    val averageScore: Int? = null,
    val meanScore: Int? = null,
    val popularity: Int? = null,
    val isLocked: Boolean? = null,
    val trending: Int? = null,
    val favourites: Int? = null,
    val tags: List<MediaTag>? = null,
    val relations: MediaConnection? = null,
    val characters: CharacterConnection? = null,
    val staff: StaffConnection? = null,
    val studios: StudioConnection? = null,
    val isFavourite: Boolean? = null,
    val isFavouriteBlocked: Boolean? = null,
    val isAdult: Boolean? = null,
    val nextAiringEpisode: AiringSchedule? = null,
    val airingSchedule: AiringScheduleConnection? = null,
    val trends: MediaTrendConnection? = null,
    val externalLinks: List<MediaExternalLink>? = null,
    val streamingEpisodes: List<MediaStreamingEpisode>? = null,
    val rankings: List<MediaRank>? = null,
    val mediaListEntry: MediaList? = null,
    val reviews: ReviewConnection? = null,
    val recommendations: RecommendationConnection? = null,
    val stats: MediaStats? = null,
    val siteUrl: String? = null,
    val autoCreateForumThread: Boolean? = null,
    val isRecommendationBlocked: Boolean? = null,
    val isReviewBlocked: Boolean? = null,
    val modNotes: String? = null
): DomainModel
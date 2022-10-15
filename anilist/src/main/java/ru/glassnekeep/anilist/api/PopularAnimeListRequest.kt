package ru.glassnekeep.anilist.api

import kotlinx.serialization.json.Json
import ru.glassnekeep.anilist.api.enums.*
import ru.glassnekeep.anilist.api.models.query.MediaQuery

data class PopularAnimeListRequest(
    val query: String,
    val variables: String
)

val mediaQuery = MediaQuery(
    id = 15355,
    type = MediaType.ANIME
)

fun make(mediaQuery: MediaQuery, title: String, variables: List<String>) {
    var string = mediaQuery.toString().replace(Regex("List<a-zA-Z>+=null,? ?"), "")
    //string = string.replace()
}


data class FuzzyDate(
    val year: Int,
    val month: Int,
    val day: Int
)

data class MediaTrailer(
    val id: String,
    val site: String,
    val thumbnail: String
)
data class MediaCoverImage(
    val extraLarge: String,
    val large: String,
    val medium: String,
    val color: String
)

data class MediaTag(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val rank: Int,
    val isGeneralSpoiler: Boolean,
    val isMediaSpoiler: Boolean,
    val isAdult: Boolean,
    val userId: Int
)

data class MediaConnection(
    val edges: MediaEdge
)

data class MediaEdge(
    val node: Media,
    val id: Int,
    val relationType: MediaRelation,
    val isMainStudio: Boolean,
    val characters: List<Character>,
)

data class Character(
    val id: Int,
    val name: CharacterName,
)

data class CharacterName(
    val first: String,
    val middle: String,
    val last: String,
    val full: String,
    val native: String,
    val alternative: List<String>,
    val alternativeSpoiler: List<String>,
    val userPreferred: String
)

data class StaffName(
    val first: String,
    val middle: String ,
    val last: String,
    val full: String,
    val native: String ,
    val alternative: List<String>,
    val userPreferred: String,
)

data class StaffImage(
    val large: String,
    val medium: String
)

data class Staff(
    val id: Int,
    val name: StaffName,
    val languageV2: String,
    val image: StaffImage,
    val description: String,
    val primaryOccupations: List<String>,
    val gender: String,
    val dateOfBirth: FuzzyDate,
    val dateOfDeath: FuzzyDate,
    val age: Int,
    val yearsActive: List<Int>,
    val homeTown: String,
    val bloodType: String,
    val isFavourite: Boolean,
    val isFavouriteBlocked: Boolean,
    val siteUrl: String,
    val staffMedia: MediaConnection,
    val characters: CharacterConnection,
    val characterMedia: MediaConnection,
    val staff: Staff,
    val submitter: User,
    val submissionStatus: Int,
    val submissionNotes: String,
    val favourites: Int,
    val modNotes: String
)

data class CharacterEdge(
    val id: Int,
    val role: CharacterRole,
    val name: String,
    val voiceActors: List<Staff>
)

data class UserAvatar(
    val large: String,
    val medium: String
)

data class NotificationOption(
    val type: NotificationType,
    val enabled: Boolean
)

data class ListActivityOption(
    val disabled: Boolean,
    val type: MediaListStatus
)

data class UserOptions(
    val titleLanguage: UserTitleLanguage,
    val displayAdultContent: Boolean,
    val airingNotifications: Boolean,
    val profileColor: String,
    val notificationOptions: List<NotificationOption>,
    val timezone: String,
    val activityMergeTime: Int,
    val staffNameLanguage: UserStaffNameLanguage,
    val restrictMessagesToFollowing: Boolean,
    val disabledListActivity: List<ListActivityOption>
)

data class MediaListTypeOptions(
    val sectionOrder: List<String>,
    val splitCompletedSectionByFormat: Boolean,
    val customLists: List<String>,
    val advancedScoring: List<String>,
    val advancedScoringEnabled: Boolean
)

data class MediaListOptions(
    val scoreFormat: ScoreFormat,
    val rowOrder: String,
    val animeList: MediaListTypeOptions,
    val mangaList: MediaListTypeOptions
)

data class StaffEdge(
    val node: Staff,
    val id: Int,
    val role: String,
    val favouriteOrder: Int
)

data class PageInfo(
    val total: Int,
    val perPage: Int,
    val currentPage: Int,
    val lastPage: Int,
    val hasNextPage: Boolean
)

data class StaffConnection(
    val edges: List<StaffEdge>,
    val nodes: List<Staff>,
    val pageInfo: PageInfo
)

data class StudioEdge(
    val id: Int,
    val isMain: Boolean,
    val favouriteOrder: Int
)

data class Studio(
    val id: Int,
    val name: String,
    val isAnimationStudio: Boolean,
    val media: MediaConnection,
    val siteUrl: String,
    val isFavourite: Boolean,
    val favourites: Int
)

data class StudioConnection(
    val edges: List<StudioEdge>,
    val nodes: List<Studio>,
    val pageInfo: PageInfo
)

data class Favourites(
    val anime: MediaConnection,
    val manga: MediaConnection,
    val characters: CharacterConnection,
    val staff: StaffConnection,
    val studios: StudioConnection
)

data class UserFormatStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val format: MediaFormat
)

data class UserStatusStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val status: MediaListStatus
)

data class UserScoreStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val score: Int
)

data class UserLengthStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val length: String
)

data class UserReleaseYearStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val releaseYear: Int
)

data class UserStartYearStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val startYear: Int
)

data class UserGenreStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val genre: String
)

data class UserTagStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val tag: MediaTag
)

data class UserCountryStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val country: String
)

data class UserVoiceActorStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val voiceActor: Staff,
    val characterIds: List<Int>
)

data class UserStaffStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val staff: Staff
)

data class UserStudioStatistic(
    val count: Int,
    val meanScore: Float,
    val minutesWatched: Int,
    val chaptersRead: Int,
    val mediaIds: List<Int>,
    val studio: Studio
)

data class UserStatistics(
    val count: Int,
    val meanScore: Float,
    val standardDeviation: Float,
    val minutesWatched: Int,
    val episodesWatched: Int,
    val chaptersRead: Int,
    val volumesRead: Int,
    val formats: List<UserFormatStatistic>,
    val statuses: List<UserStatusStatistic>,
    val scores: List<UserScoreStatistic>,
    val lengths: List<UserLengthStatistic>,
    val releaseYears: List<UserReleaseYearStatistic>,
    val startYears: List<UserStartYearStatistic>,
    val genres: List<UserGenreStatistic>,
    val tags: List<UserTagStatistic>,
    val countries: List<UserCountryStatistic>,
    val voiceActors: List<UserVoiceActorStatistic>,
    val staff: List<UserStaffStatistic>,
    val studios: List<UserStudioStatistic>,
)

data class UserStatisticTypes(
    val anime: UserStatistics,
    val manga: UserStatistics
)

data class UserPreviousName(
    val name: String,
    val createdAt: Int,
    val updatedAt: Int
)

data class User(
    val id: Int,
    val name: String,
    val about: String,
    val avatar: UserAvatar,
    val bannerImage: String,
    val isFollowing: Boolean,
    val isFollower: Boolean,
    val isBlocked: Boolean,
    val bans: Json,
    val options: UserOptions,
    val mediaListOptions: MediaListOptions,
    val favourites: Favourites,
    val statistics: UserStatisticTypes,
    val unreadNotificationCount: Int,
    val siteUrl: String,
    val donatorTier: Int,
    val donatorBadge: String,
    val moderatorRoles: List<ModRole>,
    val createdAt: Int,
    val updatedAt: Int,
    val previousNames: List<UserPreviousName>
)

data class CharacterConnection(
    val edges: List<CharacterEdge>,
    val nodes: List<Character>,
    val pageInfo: PageInfo
)

data class AiringSchedule(
    val id: Int,
    val airingAt: Int,
    val timeUntilAiring: Int,
    val episode: Int,
    val mediaId: Int,
    val media: Media
)

data class AiringScheduleEdge(
    val node: AiringSchedule,
    val id: Int
)

data class AiringScheduleConnection(
    val edges: List<AiringScheduleEdge>,
    val nodes: List<AiringSchedule>,
    val pageInfo: PageInfo
)

data class MediaTrendEdge(
    val node: MediaTrend
)

data class MediaTrend(
    val mediaId: Int,
    val date: Int,
    val trending: Int,
    val averageScore: Int,
    val popularity: Int,
    val inProgress: Int,
    val releasing: Boolean,
    val episode: Int,
    val media: Media
)

data class MediaTrendConnection(
    val edges: List<MediaTrendEdge>,
    val nodes: List<MediaTrend>,
    val pageInfo: PageInfo
)

data class MediaExternalLink(
    val id: Int,
    val url: String,
    val site: String,
    val siteId: Int,
    val type: ExternalLinkType,
    val language: String,
    val color: String,
    val icon: String,
    val notes: String,
    val isDisabled: Boolean
)

data class MediaStreamingEpisode(
    val title: String,
    val thumbnail: String,
    val url: String,
    val site: String
)

data class MediaRank(
    val id: Int,
    val rank: Int,
    val type: MediaRankType,
    val format: MediaFormat,
    val year: Int,
    val season: MediaSeason,
    val allTime: Boolean,
    val context: String
)

data class MediaList(
    val id: Int,
    val userId: Int,
    val mediaId: Int,
    val status: MediaListStatus,
    val score: Float,
    val progress: Int,
    val progressVolumes: Int,
    val repeat: Int,
    val priority: Int,
    val private: Boolean,
    val notes: String,
    val hiddenFromStatusLists: Boolean,
    val customLists: Json,
    val advancedScores: Json,
    val startedAt: FuzzyDate,
    val completedAt: FuzzyDate,
    val updatedAt: Int,
    val createdAt: Int,
    val media: Media,
    val user: User
)

data class Review(
    val id: Int,
    val userId: Int,
    val mediaId: Int,
    val mediaType: MediaType,
    val summary: String,
    val body: String,
    val rating: Int,
    val ratingAmount: Int,
    val userRating: ReviewRating,
    val score: Int,
    val private: Boolean,
    val siteUrl: String,
    val createdAt: Int,
    val updatedAt: Int,
    val user: User,
    val media: Media
)

data class ReviewEdge(
    val node: Review
)

data class ReviewConnection(
    val edges: List<ReviewEdge>,
    val nodes: List<Review>,
    val pageInfo: PageInfo
)

data class RecommendationEdge(
    val node: Recommendation
)

data class Recommendation(
    val id: Int,
    val rating: Int,
    val userRating: RecommendationRating,
    val media: Media,
    val mediaRecommendation: Media,
    val user: User
)

data class RecommendationConnection(
    val edges: List<RecommendationEdge>,
    val nodes: List<Recommendation>,
    val pageInfo: PageInfo
)

data class ScoreDistribution(
    val score: Int,
    val amount: Int
)

data class StatusDistribution(
    val status: MediaListStatus,
    val amount: Int
)

data class MediaStats(
    val scoreDistribution: List<ScoreDistribution>,
    val statusDistribution: List<StatusDistribution>
)

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
)


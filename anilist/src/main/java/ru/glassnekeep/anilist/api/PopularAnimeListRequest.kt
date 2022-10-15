package ru.glassnekeep.anilist.api

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
    string = string.replace()
}






enum class MediaTitle {
    romaji,
    english,
    native,
    userPreferred
}

enum class MediaRelation {
    ADAPTATION,
    PREQUEL,
    SEQUEL,
    PARENT,
    SIDE_STORY,
    CHARACTER,
    SUMMARY,
    ALTERNATIVE,
    SPIN_OFF,
    OTHER,
    SOURCE,
    COMPILATION,
    CONTAINS
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
    val characters(sort: List<CharacterSort>): CharacterConnection? = null,
    val staff(sort: List<StaffSort>): StaffConnection? = null,
    val studios(sort: List<StudioSort>): StudioConnection? = null,
    val isFavourite: Boolean? = null,
    val isFavouriteBlocked: Boolean? = null,
    val isAdult: Boolean? = null,
    val nextAiringEpisode: AiringSchedule? = null,
    val airingSchedule(notYetAired: Boolean): AiringScheduleConnection? = null,
    val trends(sort: List<MediaTrendSort>): MediaTrendConnection? = null,
    val externalLinks: List<MediaExternalLink>? = null,
    val streamingEpisodes: List<MediaStreamingEpisode>? = null,
    val rankings: List<MediaRank>? = null,
    val mediaListEntry: MediaList? = null,
    val reviews(limit: Int): ReviewConnection? = null,
    val recommendations(sort: List<RecommendationSort>): RecommendationConnection? = null,
    val stats: MediaStats? = null,
    val siteUrl: String? = null,
    val autoCreateForumThread: Boolean? = null,
    val isRecommendationBlocked: Boolean? = null,
    val isReviewBlocked: Boolean? = null,
    val modNotes: String? = null
)


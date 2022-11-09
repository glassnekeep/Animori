package ru.glassnekeep.anilist.api

import ru.glassnekeep.anilist.api.enums.*
import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.anilist.api.models.domain.character.CharacterConnection
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.domain.media.MediaConnection
import ru.glassnekeep.anilist.api.models.domain.media.MediaCoverImage
import ru.glassnekeep.anilist.api.models.domain.media.MediaTitle
import ru.glassnekeep.anilist.api.models.domain.recommendation.RecommendationConnection
import ru.glassnekeep.anilist.api.models.domain.studio.StudioConnection
import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.api.models.domain.character.CharacterImage
import ru.glassnekeep.anilist.api.models.domain.character.CharacterName
import ru.glassnekeep.anilist.api.models.domain.schedule.AiringSchedule
import ru.glassnekeep.anilist.api.models.domain.studio.Studio

object MockedResponses {
    val mediaResponse = Media(
        id = 0,
        title = MediaTitle(english = " "),
        idMal = 0,
        type = MediaType.ANIME,
        format = MediaFormat.MANGA,
        status = MediaStatus.FINISHED,
        description = " ",
        startDate = FuzzyDate(0, 0, 0),
        endDate = FuzzyDate(0, 0, 0),
        season = MediaSeason.FALL,
        seasonYear = 0,
        seasonInt = 0,
        episodes = 0,
        duration = 0,
        chapters = 0,
        volumes = 0,
        countryOfOrigin = " ",
        isLicensed = false,
        source = MediaSource.ANIME,
        hashtag = " ",
        updatedAt = 0,
        coverImage = MediaCoverImage(" ", " ", " ", " "),
        bannerImage = " ",
        genres = emptyList(),
        tags = emptyList(),
        relations = MediaConnection(),
        characters = CharacterConnection(),
        studios = StudioConnection(),
        isAdult = false,
        recommendations = RecommendationConnection()
    )
    val characterResponse = Character(
        id = 0,
        name = CharacterName(),
        image = CharacterImage(),
        description = "",
        gender = "male",
        age = " ",
        media = MediaConnection()
    )
    val airingScheduleResponse = AiringSchedule(
        id = 0,
        airingAt = 0,
        timeUntilAiring = 0,
        episode = 0,
        mediaId = 0,
        media = Media()
    )
    val studioResponse = Studio(
        id = 0,
        name = "",
        isAnimationStudio = true,
        media = MediaConnection()
    )
}
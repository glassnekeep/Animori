package ru.glassnekeep.media_data

import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.services.MediaRemoteService
import ru.glassnekeep.media_data.di.MediaDataScope
import javax.inject.Inject

@MediaDataScope
class MediaRepositoryImpl @Inject constructor(
    private val mediaRemoteService: MediaRemoteService
) : MediaRepository {
    override suspend fun getAnime(id: Int): Media {
        return mediaRemoteService.getMediaWithId(id)
    }

    override suspend fun getAnimeList(): List<Media> {
        return mediaRemoteService.getMediaList(MediaQuery(type = MediaType.ANIME))
    }
}
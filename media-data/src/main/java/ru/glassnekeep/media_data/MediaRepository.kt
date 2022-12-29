package ru.glassnekeep.media_data

import ru.glassnekeep.anilist.api.models.domain.media.Media

interface MediaRepository {
    suspend fun getAnimeList(): List<Media>
}
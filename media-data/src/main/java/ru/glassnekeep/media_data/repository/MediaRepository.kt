package ru.glassnekeep.media_data.repository

import ru.glassnekeep.anilist.api.models.domain.media.Media

interface MediaRepository {
    suspend fun getAnime(id: Int): Media
    suspend fun getAnimeList(): List<Media>
}
package ru.glassnekeep.character_data.repository

import ru.glassnekeep.anilist.api.models.domain.character.Character

interface CharacterRepository {
    suspend fun getCharacter(id: Int): Character
    suspend fun getCharactersWithMediaId(mediaId: Int): List<Character>
}
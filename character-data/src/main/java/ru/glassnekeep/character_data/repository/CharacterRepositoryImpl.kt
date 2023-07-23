package ru.glassnekeep.character_data.repository

import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.services.CharacterRemoteService
import ru.glassnekeep.anilist.services.MediaRemoteService
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterRemoteService: CharacterRemoteService,
    private val mediaRemoteService: MediaRemoteService
) : CharacterRepository {
    override suspend fun getCharacter(id: Int): Character {
        return characterRemoteService.getCharacterWithId(id)
    }

    override suspend fun getCharactersWithMediaId(mediaId: Int): List<Character> {
        return mediaRemoteService.getMediaWithId(mediaId).characters?.nodes!!
    }
}
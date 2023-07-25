package ru.glassnekeep.character_data.mappers

import ru.glassnekeep.character_data.models.Character

object CharacterToCharacterMapper {
    fun map(character: ru.glassnekeep.anilist.api.models.domain.character.Character): Character {
        return Character(
            id = character.id!!,
            name = character.name?.userPreferred ?: "",
            image = character.image!!.run {
                medium ?: large!!
            }
        )
    }
}
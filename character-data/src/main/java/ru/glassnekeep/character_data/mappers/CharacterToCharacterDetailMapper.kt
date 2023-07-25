package ru.glassnekeep.character_data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import ru.glassnekeep.anilist.api.models.domain.character.Character
import ru.glassnekeep.anilist.api.models.domain.formFormattedDate
import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.media_data.MediaToAnimeDetailMapper

object CharacterToCharacterDetailMapper {
    @RequiresApi(Build.VERSION_CODES.O)
    fun map(character: Character): CharacterDetail {
        return with(character) {
            CharacterDetail(
                id = id!!,
                firstName = name?.first,
                middleName = name?.middle,
                lastName = name?.last,
                fullName = name!!.full!!,
                alternativeNames = name?.alternative ?: emptyList(),
                alternativeSpoilerNames = name?.alternativeSpoiler ?: emptyList(),
                description = description,
                gender = gender,
                dateOfBirth = dateOfBirth?.formFormattedDate(),
                age = age,
                medias = media?.edges?.map { it.node!! }!!.map(MediaToAnimeDetailMapper::map)
            )
        }
    }
}
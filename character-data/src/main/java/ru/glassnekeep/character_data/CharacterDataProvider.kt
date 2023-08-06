package ru.glassnekeep.character_data

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.character_data.repository.CharacterRepository
import ru.glassnekeep.character_data.use_cases.GetCharacterUseCase

interface CharacterDataProvider {
    val characterRepository: CharacterRepository
    val getCharacterUseCase: GetCharacterUseCase
}

val LocalCharacterDataProvider = compositionLocalOf<CharacterDataProvider> { error("No character data provider found") }
package ru.glassnekeep.character_data

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.character_data.repository.CharacterRepository

interface CharacterDataProvider {
    val characterRepository: CharacterRepository
}

val LocalCharacterDataProvider = compositionLocalOf<CharacterDataProvider> { error("No character data provider found") }
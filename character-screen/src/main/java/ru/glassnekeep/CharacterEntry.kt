package ru.glassnekeep

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.glassnekeep.core.AggregateFeatureEntry

abstract class CharacterEntry: AggregateFeatureEntry {

    final override val featureRoute = "character-details/{$ARG_CHARACTER_ID}"

    final override val arguments = listOf(
        navArgument(ARG_CHARACTER_ID) {
            type = NavType.IntType
        }
    )

    fun destination(characterId: Int) = "character-details/$characterId"

    protected companion object {
        const val ARG_CHARACTER_ID = "characterId"
    }
}
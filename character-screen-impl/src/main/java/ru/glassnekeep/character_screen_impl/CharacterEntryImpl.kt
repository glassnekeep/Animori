package ru.glassnekeep.character_screen_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.CharacterEntry
import ru.glassnekeep.character_data.LocalCharacterDataProvider
import ru.glassnekeep.core.Destinations
import javax.inject.Inject

class CharacterEntryImpl @Inject constructor(): CharacterEntry() {

    private val rootRoute = "@character-detail"

    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = featureRoute, route = rootRoute) {
            composable(route = featureRoute, arguments) {
                val characterId = it.arguments?.getInt(ARG_CHARACTER_ID)
                val characterDataProvider = LocalCharacterDataProvider.current
            }
        }
    }
}
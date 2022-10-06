package ru.glassnekeep.home_feature_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.home_feature.HomeEntry
import javax.inject.Inject

class HomeEntryImpl @Inject constructor(): HomeEntry {
    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = myProfileDestination(), route = "@home") {
            composable(route = featureRoute, arguments) {
                val userId = it.arguments
            }
        }
    }
}
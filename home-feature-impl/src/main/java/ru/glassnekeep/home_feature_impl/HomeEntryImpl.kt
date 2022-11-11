package ru.glassnekeep.home_feature_impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.home_feature.HomeEntry
import javax.inject.Inject

class HomeEntryImpl @Inject constructor(): HomeEntry() {
    override fun NavGraphBuilder.Register(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        modifier: Modifier
    ) {
        val viewModel = injectedViewModel {
            DaggerHomeComponent.builder()
        }
    }


}
package ru.glassnekeep.home_feature_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.find
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.home_feature.HomeEntry
import ru.glassnekeep.home_feature_impl.di.DaggerHomeComponent
import ru.glassnekeep.media_data.LocalMediaDataProvider
import ru.glassnekeep.title_screen.TitleEntry
import javax.inject.Inject

class HomeEntryImpl @Inject constructor(): HomeEntry() {
    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = homeDestination(), route = "@home") {
            composable(route = featureRoute, arguments) {
                val mediaDataProvider = LocalMediaDataProvider.current
                val viewModel = injectedViewModel {
                    DaggerHomeComponent.factory().create(
                        mediaDataProvider,
                    ).homeScreenComponent().create().viewModel
                }
                HomeScreen(navController, viewModel, cardOnClick = { anime ->
                    val destination = destinations.find<TitleEntry>().destination(anime.id)
                    navController.navigate(destination)
                })
            }
        }
    }
}
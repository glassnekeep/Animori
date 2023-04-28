package ru.glassnekeep.title

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.media_data.LocalMediaDataProvider
import ru.glassnekeep.title.di.DaggerTitleScreenComponent
import ru.glassnekeep.title_screen.TitleEntry
import javax.inject.Inject

class TitleEntryImpl @Inject constructor() : TitleEntry() {

    val rootRoute = "@movie-details"

    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = featureRoute, route = rootRoute) {
            composable(route = featureRoute, arguments) {
                val mediaId = it.arguments?.getInt(ARG_MEDIA_ID)
                val dataProvider = LocalMediaDataProvider.current
                val viewModel = injectedViewModel {
                    DaggerTitleScreenComponent.factory().create(
                        dataProvider,
                        mediaId ?: 0
                    ).viewModel
                }
                TitleScreen(viewModel)
            }
        }
    }

}
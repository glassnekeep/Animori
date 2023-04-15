package ru.glassnekeep.title

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.media_data.LocalMediaDataProvider
import ru.glassnekeep.title.di.DaggerTitleScreenComponent
import ru.glassnekeep.title_screen.TitleEntry
import javax.inject.Inject

class TitleEntryImpl @Inject constructor() : TitleEntry() {
    @Composable
    override fun NavGraphBuilder.Register(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        modifier: Modifier
    ) {
        val mediaId = backStackEntry.arguments?.getInt(ARG_MEDIA_ID)
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
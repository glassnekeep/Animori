package ru.glassnekeep.title

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.title_screen.TitleEntry
import ru.glassnekeep.user_data.LocalUserDataProvider
import javax.inject.Inject

class TitleEntryImpl @Inject constructor() : TitleEntry() {
    @Composable
    override fun NavGraphBuilder.Register(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        modifier: Modifier
    ) {
        val dataProvider = LocalUserDataProvider.current
        val viewModel = TitleScreenViewModel
    }

}
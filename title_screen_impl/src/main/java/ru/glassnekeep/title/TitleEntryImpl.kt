package ru.glassnekeep.title

import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.title_screen.TitleEntry
import javax.inject.Inject

class TitleEntryImpl @Inject constructor() : TitleEntry() {
    override fun NavGraphBuilder.Register(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry,
        modifier: Modifier
    ) {
        //Here need to define providers, not onlu anilist, but also my own backed provider
    }

}
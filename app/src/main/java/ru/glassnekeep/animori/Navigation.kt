package ru.glassnekeep.animori

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.core.find
import ru.glassnekeep.profile_feature.ProfileEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val profileScreen = destinations.find<ProfileEntry>()

    Box(Modifier.fillMaxSize()) {
        NavHost(navController, startDestination = "home") {
            composable("home") {

            }
            with(profileScreen) {
                navigation(navController, destinations)
            }
        }
    }

    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
        BottomMenuBar(navController, destinations)
    }
}
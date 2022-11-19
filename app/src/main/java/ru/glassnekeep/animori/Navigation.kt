package ru.glassnekeep.animori

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.animori.ui.theme.md_theme_light_onPrimary
import ru.glassnekeep.core.find
import ru.glassnekeep.home_feature.HomeEntry
import ru.glassnekeep.profile_feature.ProfileEntry

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalAppProvider.current.destinations

    val profileScreen = destinations.find<ProfileEntry>()
    val homeScreen = destinations.find<HomeEntry>()

    NavHost(navController = navController, startDestination = homeScreen.homeDestination()) {
        with(homeScreen) {
            navigation(navController, destinations)
        }
        with(profileScreen) {
            navigation(navController, destinations)
        }
    }

//    Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
//        BottomMenuBar(navController, destinations)
//    }
}

@Composable
fun BottomNav(
    navController: NavController,
    items: List<BottomNavItem>
) {
    BottomNavigation(
        contentColor = md_theme_light_onPrimary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.image, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}

sealed class BottomNavItem(val title: String, val image: ImageVector, val route: String = "") {
    object Home: BottomNavItem("Home", Icons.Filled.Home)
    object Search: BottomNavItem("Search", Icons.Filled.Search)
    object MyList: BottomNavItem("My List", Icons.Filled.List)
    object Profile: BottomNavItem("Profile", Icons.Filled.Person)
}
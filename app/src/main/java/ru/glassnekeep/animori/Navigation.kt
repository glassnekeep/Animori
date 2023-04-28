package ru.glassnekeep.animori

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.core.find
import ru.glassnekeep.home_feature.HomeEntry
import ru.glassnekeep.profile_feature.ProfileEntry
import ru.glassnekeep.title_screen.TitleEntry

@Composable
fun Navigation(navController: NavHostController) {
    val destinations = LocalAppProvider.current.destinations

    val profileScreen = destinations.find<ProfileEntry>()
    val homeScreen = destinations.find<HomeEntry>()
    val titleScreen = destinations.find<TitleEntry>()

    NavHost(navController = navController, startDestination = "@home") {
        with(homeScreen) {
            navigation(navController, destinations)
        }
        with(profileScreen) {
            navigation(navController, destinations)
        }
        with(titleScreen) {
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
        //contentColor = md_theme_light_onPrimary
    ) {
        var selectedItem by remember { mutableStateOf("@home") }
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = item.image, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = item.route == selectedItem,
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route)
                }
            )
        }
    }
}

sealed class BottomNavItem(val title: String, val image: ImageVector, val route: String = "") {
    object Home: BottomNavItem("Home", Icons.Filled.Home, "@home")
    object Search: BottomNavItem("Search", Icons.Filled.Search)
    object MyList: BottomNavItem("My List", Icons.Filled.List)
    object Profile: BottomNavItem("Profile", Icons.Filled.Person, "profile")
}
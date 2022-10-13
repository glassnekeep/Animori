package ru.glassnekeep.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object Routes {
    const val HOME = "Home"
    const val CHATS = "Chats"
    const val SEARCH = "Search"
    const val MYLIST = "My List"
    const val PROFILE = "Profile"
}

data class TopLevelDestinations(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

class NavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: TopLevelDestinations) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestinations(
        route = Routes.HOME,
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        iconTextId = R.string.home
    ),
    TopLevelDestinations(
        route = Routes.CHATS,
        selectedIcon = Icons.Default.Email,
        unselectedIcon = Icons.Default.Email,
        iconTextId = R.string.chats
    ),
    TopLevelDestinations(
        route = Routes.SEARCH,
        selectedIcon = Icons.Default.Search,
        unselectedIcon = Icons.Default.Search,
        iconTextId = R.string.search
    ),
    TopLevelDestinations(
        route = Routes.MYLIST,
        selectedIcon = Icons.Default.List,
        unselectedIcon = Icons.Default.List,
        iconTextId = R.string.my_list
    ),
    TopLevelDestinations(
        route = Routes.PROFILE,
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        iconTextId = R.string.profile
    )
)
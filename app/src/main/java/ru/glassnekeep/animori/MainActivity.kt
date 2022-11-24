package ru.glassnekeep.animori

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.animori.ui.theme.AnimoriTheme
import ru.glassnekeep.core.ComposableFeatureEntry
import ru.glassnekeep.core.find
import ru.glassnekeep.home_feature_impl.HomeScreen
import ru.glassnekeep.home_feature_impl.HomeViewModel
import ru.glassnekeep.home_feature_impl.LocalHomeDataProvider
import ru.glassnekeep.profile_feature.ProfileEntry
import ru.glassnekeep.profile_feature_impl.LocalProfileDataProvider
import ru.glassnekeep.user_data.LocalUserDataProvider

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimoriTheme {
                CompositionLocalProvider(
                    LocalAppProvider provides application.appProvider,
                    LocalProfileDataProvider provides application.appProvider,
                    LocalUserDataProvider provides application.appProvider,
                    LocalHomeDataProvider provides application.appProvider
                ) {
                    StartScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen() {
    val bottomNavigationItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.MyList,
        BottomNavItem.Profile
    )
    val navController = rememberNavController()
    Scaffold (
        bottomBar = {
            BottomNav(navController, bottomNavigationItems)
        }
    ) {
        Navigation(navController)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimoriTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AnimoriTheme {
        HomeScreen(navController = rememberNavController(), viewModel = HomeViewModel())
    }
}
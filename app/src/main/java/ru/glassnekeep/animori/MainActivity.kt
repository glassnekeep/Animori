package ru.glassnekeep.animori

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.character_data.LocalCharacterDataProvider
import ru.glassnekeep.design_system.theme.AnimoriTheme
import ru.glassnekeep.home_feature_impl.LocalHomeDataProvider
import ru.glassnekeep.media_data.LocalMediaDataProvider
import ru.glassnekeep.profile_feature_impl.LocalProfileDataProvider
import ru.glassnekeep.title.LocalTitleDataProvider
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
                    LocalMediaDataProvider provides application.appProvider,
                    LocalCharacterDataProvider provides application.appProvider,
                    LocalHomeDataProvider provides application.appProvider,
                    LocalTitleDataProvider provides application.appProvider
                ) {
                    StartScreen()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
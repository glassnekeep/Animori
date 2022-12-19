package ru.glassnekeep.animori.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider
import ru.glassnekeep.user_data.UserDataProvider

interface AppProvider : ProfileDataProvider, UserDataProvider, HomeDataProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> {
    error("No App provider found")
}
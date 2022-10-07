package ru.glassnekeep.animori.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider

interface AppProvider : ProfileDataProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> {
    error("No App provider found")
}
package ru.glassnekeep.animori.di

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.media_data.MediaDataProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider
import ru.glassnekeep.title.TitleDataProvider
import ru.glassnekeep.user_data.UserDataProvider

interface AppProvider : ProfileDataProvider, UserDataProvider, HomeDataProvider, MediaDataProvider, TitleDataProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> {
    error("No App provider found")
}
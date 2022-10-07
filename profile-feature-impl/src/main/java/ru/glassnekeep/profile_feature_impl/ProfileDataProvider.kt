package ru.glassnekeep.profile_feature_impl

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.user_data.UserRepository


interface ProfileDataProvider {
    val userRepository: UserRepository
}

val LocalProfileDataProvider = compositionLocalOf<ProfileDataProvider> {
    error("No profile data provider found")
}
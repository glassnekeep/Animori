package ru.glassnekeep.user_data

import androidx.compose.runtime.compositionLocalOf

interface UserDataProvider {
    val userRepository: UserRepository
}

val LocalUserDataProvider = compositionLocalOf<UserDataProvider> { error("No user data provider found!") }
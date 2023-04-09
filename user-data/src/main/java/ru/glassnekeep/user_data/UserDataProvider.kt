package ru.glassnekeep.user_data

import androidx.compose.runtime.compositionLocalOf
import ru.glassnekeep.core.di.AppDispatchers

interface UserDataProvider {
    val userRepository: UserRepository
    val dispatchers: AppDispatchers
}

val LocalUserDataProvider = compositionLocalOf<UserDataProvider> { error("No user data provider found!") }
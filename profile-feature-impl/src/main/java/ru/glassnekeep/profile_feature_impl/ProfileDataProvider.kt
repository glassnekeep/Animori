package ru.glassnekeep.profile_feature_impl

import ru.glassnekeep.user_data.UserRepository


interface ProfileDataProvider {
    val userRepository: UserRepository
}
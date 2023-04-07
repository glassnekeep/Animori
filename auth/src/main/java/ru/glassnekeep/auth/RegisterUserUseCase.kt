package ru.glassnekeep.auth

import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.UserRepository
import ru.glassnekeep.user_data.models.User
import javax.inject.Inject

@AppScope
class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend fun execute(user: User) {
        userRepository.addUser(user)
    }
}
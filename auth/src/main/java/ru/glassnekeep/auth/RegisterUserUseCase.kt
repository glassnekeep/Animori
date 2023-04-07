package ru.glassnekeep.auth

import kotlinx.coroutines.withContext
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.UserRepository
import javax.inject.Inject

@AppScope
class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val dispatchers: AppDispatchers
) {
    suspend fun execute() {
        withContext(dispatchers.io) {
            userRepository
        }
    }
}
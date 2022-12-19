package ru.glassnekeep.user_data

import io.ktor.client.*
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.network.ApiClient
import javax.inject.Inject

@AppScope
class UserRepositoryImpl @Inject constructor(
    val client: HttpClient
) : UserRepository {
    override fun getUser() {
        println("User")
    }
}
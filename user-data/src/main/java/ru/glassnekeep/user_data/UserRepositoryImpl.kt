package ru.glassnekeep.user_data

import io.ktor.client.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val client: HttpClient
) : UserRepository {
    override fun getUser() {
        println("User")
    }
}
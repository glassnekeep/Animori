package ru.glassnekeep.user_data

import io.ktor.client.*
import ru.glassnekeep.network.ApiClient
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
//    @ApiClient
    val client: HttpClient
) : UserRepository {
    override fun getUser() {
        println("User")
    }
}
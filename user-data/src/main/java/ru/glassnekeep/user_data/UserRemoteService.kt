package ru.glassnekeep.user_data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.withContext
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.di.MediaRoute
import ru.glassnekeep.user_data.di.RegisterRoute
import ru.glassnekeep.user_data.di.UserRoute
import ru.glassnekeep.user_data.models.Media
import ru.glassnekeep.user_data.models.User
import javax.inject.Inject

@AppScope
class UserRemoteService @Inject constructor(
    private val client: HttpClient,
    private val dispatchers: AppDispatchers,
    private val contentType: ContentType,
    @UserRoute private val userRoute: String,
    @MediaRoute private val mediaRoute: String,
    @RegisterRoute private val registerRoute: String
) {
    suspend fun getUserWithId(id: Long): User {
        return withContext(dispatchers.io) {
            client.get("/$userRoute/$id").body()
        }
    }

    suspend fun addUser(user: User) = withContext(dispatchers.io) {
        client.post("/$registerRoute") {
            contentType(contentType)
            setBody(user)
        }
    }

    suspend fun updateUser(user: User) = withContext(dispatchers.io) {
        client.put("/$userRoute") {
            contentType(contentType)
            setBody(user)
        }
    }

    suspend fun deleteUserWithId(id: Long) = withContext(dispatchers.io) {
        client.delete("/$userRoute/$id")
    }

    suspend fun addMediasToUser(medias: List<Media>, userId: Long) = withContext(dispatchers.io) {
        client.post("/$mediaRoute/$userRoute/$userId") {
            contentType(contentType)
            setBody(medias)
        }
    }

    suspend fun deleteMediasFromUser(medias: List<Media>, userId: Long) = withContext(dispatchers.io) {
        client.delete("/$mediaRoute/$userRoute/$userId") {
            contentType(contentType)
            setBody(medias)
        }
    }

    suspend fun getMediasWithUser(userId: Long): List<Media> {
        return withContext(dispatchers.io) {
            client.get("/$mediaRoute/$userRoute/$userId").body()
        }
    }
}
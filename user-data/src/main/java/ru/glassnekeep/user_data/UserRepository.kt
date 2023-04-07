package ru.glassnekeep.user_data

import ru.glassnekeep.user_data.models.Media
import ru.glassnekeep.user_data.models.User

interface UserRepository {
    suspend fun getUser(id: Long): User
    suspend fun addUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun addMediasToUser(medias: List<Media>, userId: Long)
    suspend fun deleteMediasFromUser(medias: List<Media>, userId: Long)
    suspend fun deleteUser(id: Long)
    suspend fun getMediasWithUser(id: Long): List<Media>
}
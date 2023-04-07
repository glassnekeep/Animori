package ru.glassnekeep.user_data

import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.models.Media
import ru.glassnekeep.user_data.models.User
import javax.inject.Inject

@AppScope
class UserRepositoryImpl @Inject constructor(
    private val remote: UserRemoteService
) : UserRepository {
    override suspend fun getUser(id: Long): User {
        return remote.getUserWithId(id)
    }

    override suspend fun addUser(user: User) {
        remote.addUser(user)
    }

    override suspend fun updateUser(user: User) {
        remote.updateUser(user)
    }

    override suspend fun addMediasToUser(medias: List<Media>, userId: Long) {
        remote.addMediasToUser(medias, userId)
    }

    override suspend fun deleteMediasFromUser(medias: List<Media>, userId: Long) {
        remote.deleteMediasFromUser(medias, userId)
    }

    override suspend fun deleteUser(id: Long) {
        remote.deleteUserWithId(id)
    }

    override suspend fun getMediasWithUser(id: Long): List<Media> {
        return remote.getMediasWithUser(id)
    }

}
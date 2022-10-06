package ru.glassnekeep.profile_feature_impl.user_profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.glassnekeep.profile_feature_impl.user_profile.di.UserId
import javax.inject.Inject

class UserProfileViewModel @Inject constructor(
    @UserId private val userId: String?
) : ViewModel() {
    val isMyProfile = userId == null
    val showSettingsButton = userId == null
    val screenTitle = if (isMyProfile) "My Profile" else "Profile"

    private val mutableAvatarUrl = MutableStateFlow<String?>(null)
    val avatarUrl: StateFlow<String?> = mutableAvatarUrl

    private val mutableUsername = MutableStateFlow<String?>(null)
    val username: StateFlow<String?> = mutableUsername


//    fun images(): Flow<List<Image>> {
//        val imagesFlow =
//            if (userId != null) getUserImages(userId)
//            else getMyImages()
//
//        return imagesFlow.onEach { images ->
//            val user = images.firstOrNull()?.user
//            if (user != null) updateUserInfo(user)
//        }
//    }
//
//    private fun updateUserInfo(user: User) {
//        mutableAvatarUrl.value = user.imageUrl
//        mutableUsername.value = user.name
//    }
}
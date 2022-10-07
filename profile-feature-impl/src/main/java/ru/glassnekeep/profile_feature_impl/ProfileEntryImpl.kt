package ru.glassnekeep.profile_feature_impl

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.profile_feature.ProfileEntry
import ru.glassnekeep.profile_feature_impl.di.DaggerProfileComponent
import ru.glassnekeep.profile_feature_impl.user_profile.UserProfileViewModel
import ru.glassnekeep.profile_feature_impl.user_profile.di.DaggerUserProfileComponent
import ru.glassnekeep.user_data.LocalUserDataProvider
import ru.glassnekeep.user_data.UserDataProvider
import javax.inject.Inject

class ProfileEntryImpl @Inject constructor() : ProfileEntry() {
    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = myProfileDestination(), route = "@profile") {
            composable(route = featureRoute, arguments) {
                val userId = it.arguments?.getString(ARG_USER_ID)

                val viewModel = injectedViewModel {
                    DaggerUserProfileComponent.factory()
                        .create(buildRootProfileComponent(LocalUserDataProvider.current), userId)
                        .viewModel
                }
                UserProfileScreen(navController, viewModel)
            }
        }
    }

    private fun buildRootProfileComponent(userDataProvider: UserDataProvider) =
        DaggerProfileComponent.builder().userDataProvider(userDataProvider).build()

}


@Composable
fun UserProfileScreen(
    navController: NavController,
    viewModel: UserProfileViewModel,
) {
}
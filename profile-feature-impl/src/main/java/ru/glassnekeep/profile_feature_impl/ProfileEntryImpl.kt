package ru.glassnekeep.profile_feature_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.profile_feature.ProfileEntry
import ru.glassnekeep.profile_feature_impl.di.DaggerProfileComponent
import ru.glassnekeep.profile_feature_impl.user_profile.UserProfileScreen
import ru.glassnekeep.profile_feature_impl.user_profile.di.DaggerUserProfileComponent
import ru.glassnekeep.user_data.LocalUserDataProvider
import ru.glassnekeep.user_data.UserDataProvider
import javax.inject.Inject

class ProfileEntryImpl @Inject constructor() : ProfileEntry() {
    override fun NavGraphBuilder.navigation(
        navController: NavHostController,
        destinations: Destinations
    ) {
        navigation(startDestination = profileDestination(), route = "@profile") {
            composable(route = featureRoute, arguments) {
                val userId = it.arguments?.getString(ARG_USER_ID)
                val userDataProvider = LocalUserDataProvider.current
                val viewModel = injectedViewModel {
                    DaggerUserProfileComponent.factory()
                        .create(buildRootProfileComponent(userDataProvider), userId)
                        .viewModel
                }
                UserProfileScreen(navController, viewModel)
            }
        }
    }

    private fun buildRootProfileComponent(userDataProvider: UserDataProvider) =
        DaggerProfileComponent.factory().create(userDataProvider)

}
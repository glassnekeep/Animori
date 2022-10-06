package ru.glassnekeep.profile_feature_impl

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.glassnekeep.core.Destinations
import ru.glassnekeep.core.injectedViewModel
import ru.glassnekeep.profile_feature.ProfileEntry
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
                    DaggerUser
                }
            }
        }
    }

}
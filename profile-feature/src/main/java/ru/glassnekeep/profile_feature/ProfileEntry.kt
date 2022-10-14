package ru.glassnekeep.profile_feature

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.glassnekeep.core.AggregateFeatureEntry

abstract class ProfileEntry : AggregateFeatureEntry {

    /**
     * Declares an entry route of the feature.
     */
    final override val featureRoute = "profile?$ARG_USER_ID={$ARG_USER_ID}"

    /**
     * Declares arguments of an entry route of the feature.
     */
    final override val arguments = listOf(
        navArgument(ARG_USER_ID) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        }
    )

    /**
     * Builds destination to the profile page of a specific user.
     */
    fun userProfileDestination(userId: String): String =
        "profile?$ARG_USER_ID=$userId"

    /**
     * Builds destination to the profile page of current user.
     */
    fun profileDestination(): String =
        "profile"


    protected companion object {
        const val ARG_USER_ID = "userId"
    }
}
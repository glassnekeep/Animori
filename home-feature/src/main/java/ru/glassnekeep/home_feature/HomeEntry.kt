package ru.glassnekeep.home_feature

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.glassnekeep.core.AggregateFeatureEntry

abstract class HomeEntry: AggregateFeatureEntry {

    /**
     * Declares an entry root of the feature
     */
    final override val featureRoute: String = "home?$ARG_USER_ID={$ARG_USER_ID}"

    /**
     * Declares arguments of an entry route of the feature
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
    fun myProfileDestination(): String =
        "profile"

    protected companion object {
        const val ARG_USER_ID = "userId"
    }
}
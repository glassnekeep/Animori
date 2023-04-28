package ru.glassnekeep.title_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.glassnekeep.core.AggregateFeatureEntry

abstract class TitleEntry : AggregateFeatureEntry {

    final override val featureRoute = "media-details/{$ARG_MEDIA_ID}"

    final override val arguments = listOf(
        navArgument(ARG_MEDIA_ID) {
            type = NavType.IntType
        }
    )

    fun destination(mediaId: Int) = "media-details/$mediaId"

    protected companion object {
        const val ARG_MEDIA_ID = "mediaId"
    }
}
package ru.glassnekeep.title_screen

import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.glassnekeep.core.ComposableFeatureEntry

abstract class TitleEntry : ComposableFeatureEntry {

    final override val featureRoute = "title/{$ARG_MEDIA_ID}"

    final override val arguments = listOf(navArgument(ARG_MEDIA_ID) {
        type = NavType.IntType
    })

    fun destination(mediaId: Int) = "media-details/$mediaId"

    protected companion object {
        const val ARG_MEDIA_ID = "mediaId"
    }
}
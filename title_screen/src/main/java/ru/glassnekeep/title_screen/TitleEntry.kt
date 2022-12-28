package ru.glassnekeep.title_screen

import ru.glassnekeep.core.ComposableFeatureEntry

abstract class TitleEntry: ComposableFeatureEntry {

    final override val featureRoute = "title"

    fun destination() = featureRoute
}
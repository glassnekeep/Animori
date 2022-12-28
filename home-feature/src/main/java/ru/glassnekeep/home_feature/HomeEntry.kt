package ru.glassnekeep.home_feature

import ru.glassnekeep.core.AggregateFeatureEntry

abstract class HomeEntry: AggregateFeatureEntry {
    final override val featureRoute: String = "home"
    fun homeDestination() = featureRoute
}
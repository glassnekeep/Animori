package ru.glassnekeep.home_feature

import ru.glassnekeep.core.FeatureApi

interface HomeFeatureApi : FeatureApi{
    fun homeRoute(): String
}
package ru.glassnekeep.core.di

import dagger.MapKey
import ru.glassnekeep.core.FeatureEntry
import kotlin.reflect.KClass

@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)


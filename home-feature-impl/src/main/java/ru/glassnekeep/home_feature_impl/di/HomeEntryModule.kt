package ru.glassnekeep.home_feature_impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.glassnekeep.core.FeatureEntry
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.FeatureEntryKey
import ru.glassnekeep.core.di.FeatureScope
import ru.glassnekeep.home_feature.HomeEntry
import ru.glassnekeep.home_feature_impl.HomeEntryImpl

@Module
interface HomeEntryModule {
    @Binds
    @AppScope
    @IntoMap
    @FeatureEntryKey(HomeEntry::class)
    fun homeEntry(entry: HomeEntryImpl): FeatureEntry
}
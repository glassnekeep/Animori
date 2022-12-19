package ru.glassnekeep.profile_feature_impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.glassnekeep.core.FeatureEntry
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.FeatureEntryKey
import ru.glassnekeep.core.di.FeatureScope
import ru.glassnekeep.profile_feature.ProfileEntry
import ru.glassnekeep.profile_feature_impl.ProfileEntryImpl
import javax.inject.Scope

@Module
interface ProfileEntryModule {

    @Binds
    @AppScope
    @IntoMap
    @FeatureEntryKey(ProfileEntry::class)
    fun profileEntry(entry: ProfileEntryImpl): FeatureEntry
}

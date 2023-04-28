package ru.glassnekeep.title.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.glassnekeep.core.FeatureEntry
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.FeatureEntryKey
import ru.glassnekeep.title.TitleEntryImpl
import ru.glassnekeep.title_screen.TitleEntry

@Module
interface TitleEntryModule {
    @Binds
    @AppScope
    @IntoMap
    @FeatureEntryKey(TitleEntry::class)
    fun titleEntry(entry: TitleEntryImpl): FeatureEntry
}
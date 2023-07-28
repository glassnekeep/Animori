package ru.glassnekeep.character_screen_impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.glassnekeep.CharacterEntry
import ru.glassnekeep.character_screen_impl.CharacterEntryImpl
import ru.glassnekeep.core.FeatureEntry
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.FeatureEntryKey

@Module
interface CharacterEntryModule {

    @Binds
    @AppScope
    @IntoMap
    @FeatureEntryKey(CharacterEntry::class)
    fun characterEntry(entry: CharacterEntryImpl): FeatureEntry
}
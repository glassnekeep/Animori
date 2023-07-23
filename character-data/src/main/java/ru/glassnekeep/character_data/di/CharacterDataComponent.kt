package ru.glassnekeep.character_data.di

import dagger.Component
import ru.glassnekeep.anilist.api.di.AnilistDataProvider
import ru.glassnekeep.character_data.CharacterDataProvider
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule

@AppScope
@CharacterDataScope
@Component(
    modules = [CharacterDataModule::class, CoreModule::class],
    dependencies = [AnilistDataProvider::class]
)
interface CharacterDataComponent: CharacterDataProvider {

    @Component.Factory
    interface Factory {
        fun create(parent: AnilistDataProvider): CharacterDataComponent
    }
}
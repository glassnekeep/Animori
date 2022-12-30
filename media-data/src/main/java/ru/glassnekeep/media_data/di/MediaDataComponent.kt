package ru.glassnekeep.media_data.di

import dagger.Component
import ru.glassnekeep.anilist.api.di.AnilistDataProvider
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule
import ru.glassnekeep.media_data.MediaDataProvider

@AppScope
@MediaDataScope
@Component(
    modules = [MediaDataModule::class, CoreModule::class],
    dependencies = [AnilistDataProvider::class],
)
interface MediaDataComponent: MediaDataProvider {
    @Component.Factory
    interface Factory {
        fun create(parent: AnilistDataProvider): MediaDataComponent
    }
}
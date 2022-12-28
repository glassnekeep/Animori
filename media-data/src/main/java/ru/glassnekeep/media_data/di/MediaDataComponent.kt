package ru.glassnekeep.media_data.di

import dagger.Component
import ru.glassnekeep.anilist.api.di.AnilistDataProvider
import ru.glassnekeep.media_data.MediaDataProvider

@MediaDataScope
@Component(
    dependencies = [AnilistDataProvider::class],
    modules = [MediaDataModule::class]
)
interface MediaDataComponent: MediaDataProvider {
    @Component.Factory
    interface Factory {
        fun create(parent: AnilistDataProvider): MediaDataComponent
    }
}
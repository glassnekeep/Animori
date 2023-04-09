package ru.glassnekeep.title.di

import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.media_data.MediaDataProvider
import ru.glassnekeep.title.TitleDataProvider

@Component(
    dependencies = [MediaDataProvider::class],
    modules = [TitleModule::class]
)
interface TitleScreenComponent: TitleDataProvider, MediaDataProvider {
    interface Factory {
        fun create(
            userDataProvider: MediaDataProvider,
            @BindsInstance @MediaId mediaId: Int
        ): TitleScreenComponent
    }
}
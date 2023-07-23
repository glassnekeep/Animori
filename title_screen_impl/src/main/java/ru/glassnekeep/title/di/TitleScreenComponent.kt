package ru.glassnekeep.title.di

import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.character_data.CharacterDataProvider
import ru.glassnekeep.media_data.MediaDataProvider
import ru.glassnekeep.title.TitleDataProvider
import ru.glassnekeep.title.TitleScreenViewModel

@Component(
    dependencies = [MediaDataProvider::class, CharacterDataProvider::class],
    modules = [TitleModule::class]
)
interface TitleScreenComponent: TitleDataProvider, MediaDataProvider, CharacterDataProvider {
    val viewModel: TitleScreenViewModel
    @Component.Factory
    interface Factory {
        fun create(
            mediaDataProvider: MediaDataProvider,
            characterDataProvider: CharacterDataProvider,
            @BindsInstance @MediaId mediaId: Int
        ): TitleScreenComponent
    }
}
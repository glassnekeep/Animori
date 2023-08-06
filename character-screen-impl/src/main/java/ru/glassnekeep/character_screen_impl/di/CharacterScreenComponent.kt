package ru.glassnekeep.character_screen_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.character_data.CharacterDataProvider
import ru.glassnekeep.character_screen_impl.view_model.CharacterScreenViewModel

@Component(
    dependencies = [CharacterDataProvider::class],
    modules = [CharacterModule::class]
)
interface CharacterScreenComponent: CharacterDataProvider {
    val viewModel: CharacterScreenViewModel

    @Component.Factory
    interface Factory {
        fun create(
            characterDataProvider: CharacterDataProvider,
            @BindsInstance @CharacterId characterId: Int
        ): CharacterScreenComponent
    }
}
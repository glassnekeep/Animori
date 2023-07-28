package ru.glassnekeep.character_screen_impl.di

import dagger.Component
import ru.glassnekeep.character_data.CharacterDataProvider
import ru.glassnekeep.media_data.MediaDataProvider

@Component(
    dependencies = [CharacterDataProvider::class, MediaDataProvider::class],
    modules = [CharacterModule::class]
)
interface CharacterScreenComponent {

}
package ru.glassnekeep.character_data.di

import dagger.Binds
import dagger.Module
import ru.glassnekeep.anilist.api.di.AniListModule
import ru.glassnekeep.character_data.repository.CharacterRepository
import ru.glassnekeep.character_data.repository.CharacterRepositoryImpl

@Module(includes = [AniListModule::class])
interface CharacterDataModule {
    @Binds
    @CharacterDataScope
    fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}
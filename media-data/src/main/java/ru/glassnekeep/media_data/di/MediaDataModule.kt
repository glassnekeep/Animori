package ru.glassnekeep.media_data.di

import dagger.Binds
import dagger.Module
import ru.glassnekeep.anilist.api.di.AniListModule
import ru.glassnekeep.media_data.MediaRepository
import ru.glassnekeep.media_data.MediaRepositoryImpl

@Module(includes = [AniListModule::class])
interface MediaDataModule {
    @Binds
    @MediaDataScope
    fun bindMediaRepository(impl: MediaRepositoryImpl): MediaRepository
}
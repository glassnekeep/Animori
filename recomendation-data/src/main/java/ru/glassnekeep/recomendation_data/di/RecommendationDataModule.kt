package ru.glassnekeep.recomendation_data.di

import dagger.Binds
import dagger.Module
import ru.glassnekeep.anilist.api.di.AniListModule
import ru.glassnekeep.recomendation_data.repository.RecommendationRepository
import ru.glassnekeep.recomendation_data.repository.RecommendationRepositoryImpl

@Module(includes = [AniListModule::class])
interface RecommendationDataModule {
    @Binds
    @RecommendationDataScope
    fun bindRecommendationRepository(impl: RecommendationRepositoryImpl): RecommendationRepository
}
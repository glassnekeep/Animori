package ru.glassnekeep.recomendation_data.di

import dagger.Component
import ru.glassnekeep.anilist.api.di.AnilistDataProvider
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule
import ru.glassnekeep.recomendation_data.RecommendationDataProvider

@AppScope
@RecommendationDataScope
@Component(
    modules = [RecommendationDataModule::class, CoreModule::class],
    dependencies = [AnilistDataProvider::class]
)
interface RecommendationDataComponent: RecommendationDataProvider {
    @Component.Factory
    interface Factory {
        fun create(parent: AnilistDataProvider): RecommendationDataComponent
    }
}
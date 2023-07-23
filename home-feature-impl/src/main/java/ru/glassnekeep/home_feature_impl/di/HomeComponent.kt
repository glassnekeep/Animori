package ru.glassnekeep.home_feature_impl.di

import dagger.Component
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.media_data.MediaDataProvider

@HomeScope
@Component(
    dependencies = [MediaDataProvider::class],
    modules = [HomeModule::class]
)
interface HomeComponent : HomeDataProvider {
    @Component.Factory
    interface Factory {
        fun create(
            mediaDataProvider: MediaDataProvider,
        ): HomeComponent
    }

    fun homeScreenComponent(): HomeScreenComponent.Factory
}
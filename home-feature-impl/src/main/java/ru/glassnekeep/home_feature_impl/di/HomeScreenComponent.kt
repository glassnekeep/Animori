package ru.glassnekeep.home_feature_impl.di

import dagger.Component
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.home_feature_impl.HomeViewModel

@HomeScreenScope
@Component(
    modules = [HomeScreenModule::class],
    dependencies = [HomeDataProvider::class]
)
interface HomeScreenComponent {
    val viewModel: HomeViewModel

    @Component.Factory
    interface Factory {
        fun create(
            parent: HomeDataProvider
        ) : HomeScreenComponent
    }
}
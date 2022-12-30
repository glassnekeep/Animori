package ru.glassnekeep.home_feature_impl.di

import dagger.Subcomponent
import ru.glassnekeep.home_feature_impl.HomeViewModel

@HomeScreenScope
@Subcomponent(
    modules = [HomeScreenModule::class],
)
interface HomeScreenComponent {
    val viewModel: HomeViewModel
    @Subcomponent.Factory
    interface Factory {
        fun create() : HomeScreenComponent
    }
}
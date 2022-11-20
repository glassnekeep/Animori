package ru.glassnekeep.animori.di

import dagger.Component
import ru.glassnekeep.animori.AnimoriApplication
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider
import ru.glassnekeep.profile_feature_impl.di.ProfileScope

@AppScope
@Component(
    dependencies = [ProfileDataProvider::class, HomeDataProvider::class],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider {
    @Component.Factory
    interface Factory {
        fun create(profileDataProvider: ProfileDataProvider, homeDataProvider: HomeDataProvider): AppComponent
    }
    fun inject(application: AnimoriApplication)
}
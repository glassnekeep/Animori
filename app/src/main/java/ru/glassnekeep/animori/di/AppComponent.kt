package ru.glassnekeep.animori.di

import dagger.Component
import ru.glassnekeep.animori.AnimoriApplication
import ru.glassnekeep.character_data.CharacterDataProvider
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule
import ru.glassnekeep.home_feature_impl.HomeDataProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider

//TODO Отсюда нужно потом убрать MediaDataProvider и его зависимости внести в HomeDataProvider
@AppScope
@Component(
    dependencies = [
        ProfileDataProvider::class,
        HomeDataProvider::class,
        CharacterDataProvider::class],
    modules = [
        CoreModule::class,
        NavigationModule::class]
)
interface AppComponent : AppProvider {
    @Component.Factory
    interface Factory {
        fun create(
            profileDataProvider: ProfileDataProvider,
            homeDataProvider: HomeDataProvider,
            characterDataProvider: CharacterDataProvider
        ): AppComponent
    }
    fun inject(application: AnimoriApplication)
}
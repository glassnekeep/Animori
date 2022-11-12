package ru.glassnekeep.animori.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.animori.AnimoriApplication
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.home_feature.HomeDataProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider
import ru.glassnekeep.profile_feature_impl.di.ProfileScope

@AppScope
@ProfileScope
@Component(
    dependencies = [ProfileDataProvider::class, HomeDataProvider::class],
    modules = [NavigationModule::class]
)
interface AppComponent : AppProvider {
    fun inject(application: AnimoriApplication)
}
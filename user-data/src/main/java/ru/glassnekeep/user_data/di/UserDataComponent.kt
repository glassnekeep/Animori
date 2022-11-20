package ru.glassnekeep.user_data.di

import dagger.Component
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.network.NetworkComponent
import ru.glassnekeep.user_data.UserDataProvider

@AppScope
@Component(
    //dependencies = [NetworkComponent::class],
    modules = [UserDataModule::class]
)
interface UserDataComponent: UserDataProvider {
    @Component.Factory
    interface Factory {
        fun create(): UserDataComponent
    }
}
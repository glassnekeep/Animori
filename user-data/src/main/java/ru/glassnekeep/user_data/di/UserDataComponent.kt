package ru.glassnekeep.user_data.di

import dagger.Component
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule
import ru.glassnekeep.user_data.UserDataProvider

@AppScope
@Component(
    modules = [UserDataModule::class, CoreModule::class]
)
interface UserDataComponent: UserDataProvider {
    @Component.Factory
    interface Factory {
        fun create(): UserDataComponent
    }
}
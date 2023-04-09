package ru.glassnekeep.auth.di

import dagger.Component
import ru.glassnekeep.auth.AuthViewModel
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.user_data.UserDataProvider

@AppScope
@Component(
    dependencies = [UserDataProvider::class],
    modules = [AuthModule::class]
)
interface AuthComponent: UserDataProvider {
    val viewModel: AuthViewModel
    @Component.Factory
    interface Factory {
        fun create(userDataProvider: UserDataProvider): AuthComponent
    }
}
package ru.glassnekeep.network

import dagger.Component
import dagger.Provides
import ru.glassnekeep.core.di.AppScope
import javax.inject.Singleton

@AppScope
@Component(
    modules = [NetworkModule::class]
)
interface NetworkComponent: NetworkProvider {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }
}
package ru.glassnekeep.user_data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.network.NetworkModule
import ru.glassnekeep.user_data.UserRepository
import ru.glassnekeep.user_data.UserRepositoryImpl

@Module(includes = [NetworkModule::class])
interface UserDataModule {

    @Binds
    @AppScope
    fun provideUserRepository(impl: UserRepositoryImpl) : UserRepository

    companion object {
        @Provides
        @UserRoute
        @AppScope
        fun provideUserRoute(): String = "user"

        @Provides
        @MediaRoute
        @AppScope
        fun provideMediaRoute(): String = "media"

        @Provides
        @RegisterRoute
        @AppScope
        fun provideRegisterRoute(): String = "register"
    }
}
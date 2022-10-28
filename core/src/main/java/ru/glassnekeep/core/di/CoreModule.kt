package ru.glassnekeep.core.di

import dagger.Module
import dagger.Provides

@Module
object CoreModule {
    @Provides
    fun provideCoroutineDispatchers() = AppDispatchers
}
package ru.glassnekeep.core.di

import dagger.Module
import dagger.Provides

@Module
object CoreModule {
    @AppScope
    @Provides
    fun provideCoroutineDispatchers(): AppDispatchers = AppDispatchers
}
package ru.glassnekeep.home_feature_impl.di

import dagger.Binds
import dagger.Module
import ru.glassnekeep.home_feature_impl.ScheduleRepository
import ru.glassnekeep.home_feature_impl.ScheduleRepositoryImpl


@Module
interface HomeModule {
    @Binds
    @HomeScreenScope
    fun provideScheduleRepository(impl: ScheduleRepositoryImpl): ScheduleRepository
}
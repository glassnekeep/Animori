package ru.glassnekeep.animori.di

import dagger.Module
import ru.glassnekeep.home_feature_impl.di.HomeEntryModule
import ru.glassnekeep.profile_feature_impl.di.ProfileEntryModule

@Module(
    includes = [ProfileEntryModule::class, HomeEntryModule::class]
)
interface NavigationModule
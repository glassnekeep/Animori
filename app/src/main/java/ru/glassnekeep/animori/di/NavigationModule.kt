package ru.glassnekeep.animori.di

import dagger.Module
import ru.glassnekeep.home_feature_impl.di.HomeEntryModule
import ru.glassnekeep.profile_feature_impl.di.ProfileEntryModule
import ru.glassnekeep.title.di.TitleEntryModule

@Module(
    includes = [ProfileEntryModule::class, HomeEntryModule::class, TitleEntryModule::class]
)
interface NavigationModule
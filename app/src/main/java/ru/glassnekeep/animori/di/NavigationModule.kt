package ru.glassnekeep.animori.di

import dagger.Module
import ru.glassnekeep.profile_feature_impl.di.ProfileEntryModule

@Module(
    includes = [ProfileEntryModule::class]
)
interface NavigationModule
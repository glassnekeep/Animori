package ru.glassnekeep.profile_feature_impl.di

import dagger.Component
import ru.glassnekeep.network.NetworkProvider
import ru.glassnekeep.network.ProfileModule
import ru.glassnekeep.profile_feature.ProfileProvider

@ProfileScope
@Component(
    dependencies = [NetworkProvider::class],
    modules = [ProfileModule::class]
)
interface ProfileComponent: ProfileProvider, NetworkProvider
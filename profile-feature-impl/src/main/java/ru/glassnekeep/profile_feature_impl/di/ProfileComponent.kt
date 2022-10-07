package ru.glassnekeep.profile_feature_impl.di

import dagger.Component
import ru.glassnekeep.profile_feature_impl.ProfileModule
import ru.glassnekeep.profile_feature.ProfileProvider
import ru.glassnekeep.profile_feature_impl.ProfileDataProvider
import ru.glassnekeep.user_data.UserDataProvider

@ProfileScope
@Component(
    dependencies = [ProfileDataProvider::class],
    modules = [ProfileModule::class]
)
interface ProfileComponent: ProfileProvider, ProfileDataProvider
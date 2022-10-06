package ru.glassnekeep.profile_feature_impl.user_profile.di

import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.profile_feature_impl.di.ProfileComponent
import ru.glassnekeep.profile_feature_impl.user_profile.UserProfileViewModel

@SubProfileScope
@Component(
    modules = [UserProfileModule::class],
    dependencies = [ProfileComponent::class]
)
interface UserProfileComponent {
    val viewModel: UserProfileViewModel

    @Component.Factory
    interface Factory {
        fun create(
            parent: ProfileComponent,
            @BindsInstance @UserId userId: String?
        ) : UserProfileComponent
    }
}
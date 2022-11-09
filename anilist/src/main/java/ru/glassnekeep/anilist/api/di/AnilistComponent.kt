package ru.glassnekeep.anilist.api.di

import dagger.Component
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule

@AppScope
@Component(modules = [
    CoreModule::class,
    AniListModule::class
])
interface AnilistComponent {
    @Component.Factory
    interface Factory {
        fun create(): AnilistComponent
    }
}
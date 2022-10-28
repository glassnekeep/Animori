package ru.glassnekeep.anilist

import dagger.Component
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.core.di.CoreModule

@Component(modules = [
    AniListModule::class,
    CoreModule::class
])
@AppScope
interface AnilistComponent {
    @Component.Factory
    interface Factory {
        fun create(): AnilistComponent
    }
}
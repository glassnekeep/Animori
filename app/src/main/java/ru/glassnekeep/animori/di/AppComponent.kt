package ru.glassnekeep.animori.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.glassnekeep.core.di.AppScope

@AppScope
@Component
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}
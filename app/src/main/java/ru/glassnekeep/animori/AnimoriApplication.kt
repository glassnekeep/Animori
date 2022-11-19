package ru.glassnekeep.animori

import android.app.Application
import ru.glassnekeep.animori.di.AppProvider
import ru.glassnekeep.animori.di.DaggerAppComponent
import ru.glassnekeep.profile_feature_impl.di.DaggerProfileComponent
import ru.glassnekeep.user_data.di.DaggerUserDataComponent

class AnimoriApplication : Application() {
    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
//        appProvider = DaggerAppComponent.builder()
//            .profileDataProvider(
//                DaggerProfileComponent.builder()
//                    .userDataProvider(
//                        DaggerUserDataComponent.builder().build()
//                ).build()
//            )
//            .homeDataProvider(
//                DaggerH
//            )
//            .build()
    }
}

val Application.appProvider: AppProvider
    get() = (this as AnimoriApplication).appProvider
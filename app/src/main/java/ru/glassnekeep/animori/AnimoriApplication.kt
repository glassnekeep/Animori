package ru.glassnekeep.animori

import android.app.Application
import ru.glassnekeep.anilist.api.di.DaggerAnilistComponent
import ru.glassnekeep.animori.di.AppProvider
import ru.glassnekeep.animori.di.DaggerAppComponent
import ru.glassnekeep.home_feature_impl.di.DaggerHomeComponent
import ru.glassnekeep.media_data.di.DaggerMediaDataComponent
import ru.glassnekeep.profile_feature_impl.di.DaggerProfileComponent
import ru.glassnekeep.user_data.di.DaggerUserDataComponent

class AnimoriApplication : Application() {

    lateinit var appProvider: AppProvider

//    val appProvider: AppProvider by lazy {
//        DaggerAppComponent.factory().create(
//            profileDataProvider = DaggerProfileComponent.factory().create(
//                userDataProvider = DaggerUserDataComponent.factory().create()
//            ),
//            homeDataProvider = DaggerHomeComponent.factory().create(
//                anilistDataProvider = DaggerAnilistComponent.factory().create()
//            )
//        )
//    }

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.factory().create(
            profileDataProvider = DaggerProfileComponent.factory().create(
                userDataProvider = DaggerUserDataComponent.factory().create()
            ),
            homeDataProvider = DaggerHomeComponent.factory().create(
                mediaDataProvider = DaggerMediaDataComponent.factory().create(
                    parent = DaggerAnilistComponent.factory().create()
                )
            )
        )
    }
}

val Application.appProvider: AppProvider
    get() = (this as AnimoriApplication).appProvider
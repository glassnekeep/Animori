package ru.glassnekeep.home_feature_impl.di

import dagger.Component
import ru.glassnekeep.anilist.api.di.AnilistComponent
import ru.glassnekeep.home_feature.HomeDataProvider

@HomeScreenScope
@Component(
    dependencies = [AnilistComponent::class],
    modules = [HomeModule::class]
)
interface HomeScreenComponent : HomeDataProvider {
    //тут может быть как фабрика, так и билдер, в других классах пока что билдер, тут решил попробовать фабрику
    // Отличие фабрики от билдера можно посмотрнеть в лекции у Дениса Загаевского пщ DI на ютубе
    @Component.Factory
    interface Factory {
        fun create(): HomeScreenComponent
    }
    //TODO Кажется по примеру, что у AnilistComponent должен быть интерфейс и эта штука должна его реализовывать, хз
}
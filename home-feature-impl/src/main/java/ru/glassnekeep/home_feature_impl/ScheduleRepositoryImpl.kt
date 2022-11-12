package ru.glassnekeep.home_feature_impl

import ru.glassnekeep.anilist.services.AiringScheduleRemoteService
import ru.glassnekeep.home_feature_impl.di.HomeScreenScope
import javax.inject.Inject

@HomeScreenScope
class ScheduleRepositoryImpl @Inject constructor(
    val remoteService: AiringScheduleRemoteService
) : ScheduleRepository{
    override fun getSchedule() {

    }
}
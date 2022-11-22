package ru.glassnekeep.home_feature_impl

import ru.glassnekeep.anilist.services.AiringScheduleRemoteService
import ru.glassnekeep.home_feature_impl.di.HomeScope
import javax.inject.Inject

@HomeScope
class ScheduleRepositoryImpl @Inject constructor(
    val remoteService: AiringScheduleRemoteService
) : ScheduleRepository{
    override fun getSchedule() {

    }
}
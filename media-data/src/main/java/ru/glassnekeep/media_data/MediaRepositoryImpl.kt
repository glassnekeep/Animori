package ru.glassnekeep.media_data

import ru.glassnekeep.anilist.services.MediaRemoteService
import ru.glassnekeep.media_data.di.MediaDataScope
import javax.inject.Inject

@MediaDataScope
class MediaRepositoryImpl @Inject constructor(
    val mediaRemoteService: MediaRemoteService
) : MediaRepository {

}
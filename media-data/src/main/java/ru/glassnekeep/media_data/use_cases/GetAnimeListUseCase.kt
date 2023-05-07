package ru.glassnekeep.media_data.use_cases

import kotlinx.coroutines.withContext
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.media_data.models.Anime
import ru.glassnekeep.media_data.repository.MediaRepository
import java.util.*
import javax.inject.Inject

@AppScope
class GetAnimeListUseCase @Inject constructor(
    private val mediaRepository: MediaRepository,
    private val dispatchers: AppDispatchers
) {
    //TODO Here requires to solve the problem with some animes with no titles (null or field title in english, for example
    suspend fun execute(): List<Anime> {
        return withContext(dispatchers.io) {
            mediaRepository.getAnimeList().map { media ->
                Anime(
                    id = media.id!!,
                    title = media.title!!.english ?: "",
                    type = media.type.toString().lowercase(Locale.ROOT)
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    description = media.description!!,
                    image = media.coverImage!!.medium ?: media.coverImage!!.large!!
                )
            }
        }
    }
}
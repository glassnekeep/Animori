package ru.glassnekeep.media_data

import kotlinx.coroutines.withContext
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.media_data.di.MediaDataScope
import ru.glassnekeep.media_data.models.Anime
import java.util.*
import javax.inject.Inject

@MediaDataScope
class GetAnimeListUseCase @Inject constructor(
    private val mediaRepository: MediaRepository,
    private val dispatchers: AppDispatchers
) {
    suspend fun execute(): List<Anime> {
        return withContext(dispatchers.io) {
            mediaRepository.getAnimeList().map { media ->
                Anime(
                    id = media.id!!,
                    title = media.title!!.english!!,
                    type = media.type.toString().lowercase(Locale.ROOT)
                        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    description = media.description!!
                )
            }
        }
    }
}
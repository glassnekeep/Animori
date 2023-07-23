package ru.glassnekeep.media_data.use_cases

import kotlinx.coroutines.withContext
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.media_data.MediaToAnimeDetailMapper
import ru.glassnekeep.media_data.models.AnimeDetail
import ru.glassnekeep.media_data.repository.MediaRepository
import java.util.Locale
import javax.inject.Inject

@AppScope
class GetAnimeUseCase @Inject constructor(
    private val repository: MediaRepository,
    private val dispatchers: AppDispatchers
) {
    suspend fun execute(id: Int): AnimeDetail = withContext(dispatchers.io) {
        repository.getAnime(id).let(MediaToAnimeDetailMapper::map)
    }
}

fun String.toLowerCaseWithFirstCapitalLetter(): String {
    return lowercase(Locale.ROOT).replaceFirstChar { if(it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
}
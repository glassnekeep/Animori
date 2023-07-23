package ru.glassnekeep.character_data.use_cases

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.models.domain.formFormattedDate
import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.character_data.repository.CharacterRepository
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.media_data.MediaToAnimeDetailMapper
import javax.inject.Inject

@AppScope
class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val dispatchers: AppDispatchers
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun execute(id: Int): CharacterDetail = withContext(dispatchers.io) {
        repository.getCharacter(id).run {
            CharacterDetail(
                id = id,
                firstName = name?.first,
                middleName = name?.middle,
                lastName = name?.last,
                fullName = name!!.full!!,
                alternativeNames = name?.alternative ?: emptyList(),
                alternativeSpoilerNames = name?.alternativeSpoiler ?: emptyList(),
                description = description,
                gender = gender,
                dateOfBirth = dateOfBirth?.formFormattedDate(),
                age = age,
                medias = media?.edges?.map { it.node!! }!!.map(MediaToAnimeDetailMapper::map)
            )
        }
    }
}
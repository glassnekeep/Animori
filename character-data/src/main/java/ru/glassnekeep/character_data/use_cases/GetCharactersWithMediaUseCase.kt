package ru.glassnekeep.character_data.use_cases

import kotlinx.coroutines.withContext
import ru.glassnekeep.character_data.models.Character
import ru.glassnekeep.character_data.repository.CharacterRepository
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class GetCharactersWithMediaUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val dispatchers: AppDispatchers
) {
    suspend fun execute(mediaId: Int): List<Character> = withContext(dispatchers.io) {
        repository.getCharactersWithMediaId(mediaId).map {
            Character(
                id = it.id!!,
                name = it.name?.userPreferred ?: "",
                image = it.image!!.run {
                    medium ?: large!!
                }
            )
        }
    }
}
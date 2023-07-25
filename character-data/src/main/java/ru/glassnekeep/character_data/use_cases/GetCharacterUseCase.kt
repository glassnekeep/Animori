package ru.glassnekeep.character_data.use_cases

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.withContext
import ru.glassnekeep.character_data.mappers.CharacterToCharacterDetailMapper
import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.character_data.repository.CharacterRepository
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import javax.inject.Inject

@AppScope
class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val dispatchers: AppDispatchers
) {
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun execute(id: Int): CharacterDetail = withContext(dispatchers.io) {
        repository.getCharacter(id).run(CharacterToCharacterDetailMapper::map)
    }
}
package ru.glassnekeep.character_screen_impl.view_model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glassnekeep.character_data.use_cases.GetCharacterUseCase
import ru.glassnekeep.character_screen_impl.di.CharacterId
import ru.glassnekeep.core.mvi.StateReducers
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
class CharacterScreenViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    @CharacterId private val characterId: Int
): ViewModel() {

    val state by StateReducers(
        initialState = CharacterState(),
        reduce = ::reduce
    )

    init {
        loadCharacter()
    }

    private fun reduce(currentState: CharacterState, event: CharacterEvent): CharacterState {
        return when(event) {
            CharacterEvent.Load -> {
                loadCharacter()
                currentState.copy(isLoading = true, errorMsg = null, data = null)
            }
            CharacterEvent.Refresh -> {
                loadCharacter()
                currentState.copy(isLoading = true, errorMsg = null)
            }
            is CharacterEvent.CharacterLoaded -> {
                currentState.copy(isLoading = false, errorMsg = null, data = event.character)
            }
        }
    }

    private fun loadCharacter() {
        viewModelScope.launch {
            getCharacterUseCase.execute(characterId).let {
                state.handleEvent(CharacterEvent.CharacterLoaded(it))
            }
        }
    }

    private companion object {
        const val DEFAULT_ERROR_MSG = "Error occurred"
        const val TAG = "Get character"
    }
}
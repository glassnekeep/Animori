package ru.glassnekeep.character_screen_impl

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.character_data.use_cases.GetCharacterUseCase
import ru.glassnekeep.character_screen_impl.di.CharacterId
import ru.glassnekeep.core.logger.Logger
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
class CharacterScreenViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
    @CharacterId private val characterId: Int
): ViewModel() {
    internal sealed class CharacterScreenState {
        object Loading: CharacterScreenState()
        data class Data(val data: CharacterDetail): CharacterScreenState()
        object NotFount: CharacterScreenState()
        data class Error(val exception: Throwable, val message: String): CharacterScreenState()
    }

    private sealed class Event {
        object Load: Event()
        object Refresh: Event()
        class NavigateToMedia(id: Int): Event()
    }

    private var _state = MutableStateFlow<CharacterScreenState>(CharacterScreenState.Loading)
    internal val state = _state.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, e ->
        _state.value = CharacterScreenState.Error(e, e.message ?: DEFAULT_ERROR_MSG)
        Logger.e(e, TAG)
    }

    init {
        loadCharacter()
    }

    private fun loadCharacter() {
        _state.value = CharacterScreenState.Loading
        viewModelScope.launch(handler) {
            getCharacterUseCase.execute(characterId).let {
                _state.value = CharacterScreenState.Data(it)
            }
        }
    }

    private fun reduce(state: CharacterScreenState, event: Event) {
        when (state) {
            is CharacterScreenState.Loading -> {
                if (event is Event.Refresh) {

                }
            }
            is CharacterScreenState.Data -> {
                if (event is Event.Refresh) {
                    loadCharacter()
                } else {

                }
            }
            is CharacterScreenState.Error -> {
                if (event is Event.Refresh) {

                }
            }
            is CharacterScreenState.NotFount -> {
                if (event is Event.Refresh) {
                    loadCharacter()
                }
            }
        }
    }

    private companion object {
        const val DEFAULT_ERROR_MSG = "Error occurred"
        const val TAG = "Get character"
    }
}
package ru.glassnekeep.title

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.glassnekeep.core.logger.Logger
import ru.glassnekeep.media_data.models.AnimeDetail
import ru.glassnekeep.media_data.use_cases.GetAnimeUseCase
import ru.glassnekeep.title.di.MediaId
import javax.inject.Inject

class TitleScreenViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    @MediaId private val mediaId: Int
): ViewModel() {
    internal sealed class TitleScreenState {
        object Loading: TitleScreenState()
        data class Data(val data: AnimeDetail): TitleScreenState()
        object NotFound: TitleScreenState()
        data class Error(val exception: Throwable, val message: String): TitleScreenState()
    }

    private sealed class Event {
        object Load: Event()
        object Refresh: Event()
        object ShowDetails: Event()
        class NavigateToCharacter(id: Int): Event()
    }

    private var _state = MutableStateFlow<TitleScreenState>(TitleScreenState.Loading)
    internal val state = _state.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, e ->
        _state.value = TitleScreenState.Error(e, e.message ?: DEFAULT_ERROR_MSG)
        Logger.e(e, TAG)
    }

    init {
        loadMedia()
    }

    private fun loadMedia() {
        _state.value = TitleScreenState.Loading
        viewModelScope.launch(handler) {
            getAnimeUseCase.execute(mediaId).let {
                _state.value = TitleScreenState.Data(it)
            }
        }
    }

    private fun loadCharacters() {

    }

    private fun reduce(state: TitleScreenState, event: Event) {
        when (state) {
            is TitleScreenState.Loading -> {
                if (event is Event.Refresh) {

                }
            }
            is TitleScreenState.Data -> {
                if (event is Event.Refresh) {
                    loadMedia()
                } else if (event is Event.ShowDetails) {

                }
            }
            is TitleScreenState.Error -> {
                if (event is Event.Refresh) {
                    loadMedia()
                }
            }
            is TitleScreenState.NotFound -> {
                if (event is Event.Refresh) {
                    loadMedia()
                }
            }
        }
    }

    private companion object {
        const val DEFAULT_ERROR_MSG = "Error occurred"
        const val TAG = "Get anime"
    }
}
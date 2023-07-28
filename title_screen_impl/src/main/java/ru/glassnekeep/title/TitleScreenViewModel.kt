package ru.glassnekeep.title

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.glassnekeep.core.logger.Logger
import ru.glassnekeep.core.mvi.Event
import ru.glassnekeep.core.mvi.State
import ru.glassnekeep.media_data.models.AnimeDetail
import ru.glassnekeep.media_data.use_cases.GetAnimeUseCase
import ru.glassnekeep.title.di.MediaId
import javax.inject.Inject

class TitleScreenViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    @MediaId private val mediaId: Int
): ViewModel() {
    internal sealed class TitleScreenState: State() {
        object Loading: TitleScreenState()
        data class Data(val data: AnimeDetail): TitleScreenState()
        object NotFound: TitleScreenState()
        data class Error(val exception: Throwable, val message: String): TitleScreenState()
    }

    private sealed class TitleEvent: Event() {
        object Load: TitleEvent()
        object Refresh: TitleEvent()
        object ShowDetails: TitleEvent()
        class NavigateToCharacter(id: Int): TitleEvent()
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

    private fun reduce(state: TitleScreenState, event: TitleEvent) {
        when (state) {
            is TitleScreenState.Loading -> {
                if (event is TitleEvent.Refresh) {

                }
            }
            is TitleScreenState.Data -> {
                if (event is TitleEvent.Refresh) {
                    loadMedia()
                } else if (event is TitleEvent.ShowDetails) {

                }
            }
            is TitleScreenState.Error -> {
                if (event is TitleEvent.Refresh) {
                    loadMedia()
                }
            }
            is TitleScreenState.NotFound -> {
                if (event is TitleEvent.Refresh) {
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
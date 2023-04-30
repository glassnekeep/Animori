package ru.glassnekeep.title

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.glassnekeep.media_data.models.AnimeDetail
import ru.glassnekeep.media_data.use_cases.GetAnimeUseCase
import ru.glassnekeep.title.di.MediaId
import javax.inject.Inject

class TitleScreenViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    @MediaId private val mediaId: Int
): ViewModel() {
    sealed class TitleState {
        object Loading: TitleState()
        data class Data(val data: AnimeDetail): TitleState()
        object NotFound: TitleState()
        data class Error(val exception: Throwable, val message: String): TitleState()
    }

    sealed class Event {
        object Load: Event()
        object Refresh: Event()
        object ShowDetails: Event()
    }

    private var _state = MutableStateFlow<TitleState>(TitleState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            loadMedia()
        }
    }

    private fun loadMedia() {
        _state.value = TitleState.Loading
        viewModelScope.launch {
            try {
                getAnimeUseCase.execute(mediaId).let {
                    _state.value = TitleState.Data(it)
                }
            } catch (exception: Exception) {
                _state.value = TitleState.Error(exception, exception.message ?: DEFAULT_ERROR_MSG)
            }
        }
    }

    fun reduce(state: TitleState, event: Event) {
        when (state) {
            is TitleState.Loading -> {
                if (event is Event.Refresh) {

                }
            }
            is TitleState.Data -> {
                if (event is Event.Refresh) {
                    loadMedia()
                } else if (event is Event.ShowDetails) {

                }
            }
            is TitleState.Error -> {
                if (event is Event.Refresh) {
                    loadMedia()
                }
            }
            is TitleState.NotFound -> {
                if (event is Event.Refresh) {
                    loadMedia()
                }
            }
        }
    }

    private companion object {
        const val DEFAULT_ERROR_MSG = "Error occurred"
    }
}
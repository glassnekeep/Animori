package ru.glassnekeep.home_feature_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ru.glassnekeep.media_data.models.Anime
import ru.glassnekeep.media_data.use_cases.GetAnimeListUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getAnimeListUseCase: GetAnimeListUseCase
) : ViewModel() {
    sealed class HomeState {
        object Loading: HomeState()
        data class Data(val data: List<Anime>) : HomeState()
    }

    private var _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            if (isActive) {
                val mediaList = getAnimeListUseCase.execute()
                _state.value = HomeState.Data(mediaList)
            }
        }
    }
}
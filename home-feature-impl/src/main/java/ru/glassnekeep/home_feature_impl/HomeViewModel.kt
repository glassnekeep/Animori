package ru.glassnekeep.home_feature_impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.services.MediaRemoteService
import ru.glassnekeep.home_feature_impl.di.HomeScreenScope
import javax.inject.Inject

@HomeScreenScope
class HomeViewModel @Inject constructor(
    mediaRemoteService: MediaRemoteService
) : ViewModel() {
    sealed class HomeState {
        object Loading: HomeState()
        data class Data(val data: List<Media>) : HomeState()
    }

    private var _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            while(isActive) {
                val mediaList = mediaRemoteService.getMediaList(MediaQuery(type = MediaType.ANIME))
                _state.value = HomeState.Data(mediaList)
            }
        }
    }
}
package ru.glassnekeep.character_screen_impl.view_model

import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.core.mvi.State

data class CharacterState(
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
    val data: CharacterDetail? = null
): State

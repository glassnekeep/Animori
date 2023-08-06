package ru.glassnekeep.character_screen_impl.view_model

import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.core.mvi.Event

sealed class CharacterEvent: Event {
    object Load: CharacterEvent()
    object Refresh: CharacterEvent()
    class CharacterLoaded(val character: CharacterDetail): CharacterEvent()
}
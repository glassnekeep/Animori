package ru.glassnekeep.core.mvi

import kotlinx.coroutines.flow.StateFlow

interface StateReducer<S: State, E: Event>: StateFlow<S> {
    fun handleEvent(event: E)
}
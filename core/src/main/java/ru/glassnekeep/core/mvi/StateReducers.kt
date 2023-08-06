package ru.glassnekeep.core.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.reflect.KProperty

class StateReducers<S: State, E: Event>(
    private val initialState: S,
    private val reduce: (S, E) -> S
) {
    operator fun getValue(thisRef: ViewModel, property: KProperty<*>): StateReducer<S, E> {
        return StateReducerImpl<S, E>(
            initialState = initialState,
            reduce = reduce,
            thisRef.viewModelScope
        )
    }
}
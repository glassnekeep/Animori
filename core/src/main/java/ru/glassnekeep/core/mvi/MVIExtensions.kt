package ru.glassnekeep.core.mvi

//fun <S: State, E: Event> ViewModel.StateReducer(
//    initialState: S,
//    reduce: (S, E) -> S,
//) : StateReducer<S, E> = StateReducerImpl<S, E>(initialState, reduce, viewModelScope)
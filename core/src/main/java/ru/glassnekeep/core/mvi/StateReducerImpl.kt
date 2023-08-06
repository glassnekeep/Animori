package ru.glassnekeep.core.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.runningFold
import kotlinx.coroutines.flow.stateIn

class StateReducerImpl<S: State, E: Event>(
    initialState: S,
    reduce: (S, E) -> S,
    scope: CoroutineScope
) : StateReducer<S, E> {

    private val events = Channel<E>()
    private val stateFlow = events
        .receiveAsFlow()
        .runningFold(initialState, reduce)
        .stateIn(scope, Eagerly, initialState)

    override val replayCache get() = stateFlow.replayCache

    override val value get() = stateFlow.value

    override suspend fun collect(collector: FlowCollector<S>): Nothing {
        stateFlow.collect(collector)
    }

    override fun handleEvent(event: E) {
        events.trySend(event)
    }
}
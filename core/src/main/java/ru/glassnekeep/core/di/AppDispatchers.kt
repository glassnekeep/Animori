package ru.glassnekeep.core.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher

object AppDispatchers {
    val main: MainCoroutineDispatcher = Dispatchers.Main
    val default: CoroutineDispatcher = Dispatchers.Default
    val io: CoroutineDispatcher = Dispatchers.IO
    val unconfined: CoroutineDispatcher = Dispatchers.Unconfined
}
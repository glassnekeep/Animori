package ru.glassnekeep.network

import androidx.compose.runtime.compositionLocalOf
import io.ktor.client.*

interface NetworkProvider {
    val client: HttpClient
}

val LocalClientProvider = compositionLocalOf<NetworkProvider> { error("No network provider found!") }
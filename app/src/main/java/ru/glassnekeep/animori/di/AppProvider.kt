package ru.glassnekeep.animori.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.composable
import ru.glassnekeep.core.Destinations

interface AppProvider {
    val destinations: Destinations
}
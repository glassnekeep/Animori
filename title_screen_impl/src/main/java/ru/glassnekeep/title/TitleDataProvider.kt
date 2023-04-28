package ru.glassnekeep.title

import androidx.compose.runtime.compositionLocalOf

interface TitleDataProvider {

}

val LocalTitleDataProvider = compositionLocalOf<TitleDataProvider> { error("No title data provider found!") }
package ru.glassnekeep.profile_feature

import androidx.compose.runtime.compositionLocalOf

interface ProfileProvider

val LocalProfileProvider = compositionLocalOf<ProfileProvider> {
    error("No profile provider found")
}
package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable

@Serializable
data class FuzzyDate(
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null
)
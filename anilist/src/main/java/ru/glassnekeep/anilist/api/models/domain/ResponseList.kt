package ru.glassnekeep.anilist.api.models.domain

import kotlinx.serialization.Serializable

@Serializable
data class ResponseList(
    val data: Data,
)

@Serializable
data class Data(
    val page: Page,
)

package ru.glassnekeep.anilist.api.models.domain.review

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class ReviewEdge(
    val node: Review? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.score

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class ScoreDistribution(
    val score: Int? = null,
    val amount: Int? = null
): DomainModel
package ru.glassnekeep.anilist.api.models.domain.score

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class ScoreDistribution(
    val score: Int? = null,
    val amount: Int? = null
): DomainModel
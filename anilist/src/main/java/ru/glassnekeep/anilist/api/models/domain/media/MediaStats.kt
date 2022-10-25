package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.score.ScoreDistribution
import ru.glassnekeep.anilist.api.models.domain.status.StatusDistribution

data class MediaStats(
    val scoreDistribution: List<ScoreDistribution>? = null,
    val statusDistribution: List<StatusDistribution>? = null
): DomainModel
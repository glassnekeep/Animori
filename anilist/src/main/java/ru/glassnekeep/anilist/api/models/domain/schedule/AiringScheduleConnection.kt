package ru.glassnekeep.anilist.api.models.domain.schedule

import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class AiringScheduleConnection(
    val edges: List<AiringScheduleEdge>? = null,
    val nodes: List<AiringSchedule>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
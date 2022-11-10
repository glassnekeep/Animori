package ru.glassnekeep.anilist.api.models.domain.schedule

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class AiringScheduleConnection(
    val edges: List<AiringScheduleEdge>? = null,
    val nodes: List<AiringSchedule>? = null,
    val pageInfo: PageInfo? = null
): DomainModel
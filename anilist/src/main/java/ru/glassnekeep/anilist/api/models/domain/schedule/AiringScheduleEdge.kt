package ru.glassnekeep.anilist.api.models.domain.schedule

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class AiringScheduleEdge(
    val node: AiringSchedule? = null,
    val id: Int? = null
): DomainModel
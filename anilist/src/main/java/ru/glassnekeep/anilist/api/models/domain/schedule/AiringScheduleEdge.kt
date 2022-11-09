package ru.glassnekeep.anilist.api.models.domain.schedule

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class AiringScheduleEdge(
    val node: AiringSchedule? = null,
    val id: Int? = null
): DomainModel
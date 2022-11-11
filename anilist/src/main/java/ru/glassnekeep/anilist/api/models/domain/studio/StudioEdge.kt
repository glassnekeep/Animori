package ru.glassnekeep.anilist.api.models.domain.studio

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class StudioEdge(
    val id: Int? = null,
    val isMain: Boolean? = null,
    val favouriteOrder: Int? = null
): DomainModel
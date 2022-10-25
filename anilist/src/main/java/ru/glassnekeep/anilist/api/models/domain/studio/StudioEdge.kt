package ru.glassnekeep.anilist.api.models.domain.studio

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class StudioEdge(
    val id: Int? = null,
    val isMain: Boolean? = null,
    val favouriteOrder: Int? = null
): DomainModel
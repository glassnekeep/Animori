package ru.glassnekeep.anilist.api.models.domain.review

import ru.glassnekeep.anilist.api.models.domain.DomainModel

data class ReviewEdge(
    val node: Review? = null
): DomainModel
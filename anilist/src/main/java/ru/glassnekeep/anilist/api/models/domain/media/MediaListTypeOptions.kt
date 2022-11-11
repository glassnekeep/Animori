package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaListTypeOptions(
    val sectionOrder: List<String>? = null,
    val splitCompletedSectionByFormat: Boolean? = null,
    val customLists: List<String>? = null,
    val advancedScoring: List<String>? = null,
    val advancedScoringEnabled: Boolean? = null
): DomainModel
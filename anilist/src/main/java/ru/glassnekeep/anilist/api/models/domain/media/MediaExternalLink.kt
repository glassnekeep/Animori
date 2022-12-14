package ru.glassnekeep.anilist.api.models.domain.media

import kotlinx.serialization.Serializable
import ru.glassnekeep.anilist.api.enums.ExternalLinkType
import ru.glassnekeep.anilist.api.models.domain.DomainModel

@Serializable
data class MediaExternalLink(
    val id: Int? = null,
    val url: String? = null,
    val site: String? = null,
    val siteId: Int? = null,
    val type: ExternalLinkType? = null,
    val language: String? = null,
    val color: String? = null,
    val icon: String? = null,
    val notes: String? = null,
    val isDisabled: Boolean? = null
): DomainModel
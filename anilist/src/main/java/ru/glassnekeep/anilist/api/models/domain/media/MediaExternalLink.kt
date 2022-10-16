package ru.glassnekeep.anilist.api.models.domain.media

import ru.glassnekeep.anilist.api.enums.ExternalLinkType

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
)
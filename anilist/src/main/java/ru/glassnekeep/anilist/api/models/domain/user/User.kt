package ru.glassnekeep.anilist.api.models.domain.user

import kotlinx.serialization.json.Json
import ru.glassnekeep.anilist.api.Favourites
import ru.glassnekeep.anilist.api.enums.ModRole
import ru.glassnekeep.anilist.api.models.domain.DomainModel
import ru.glassnekeep.anilist.api.models.domain.media.MediaListOptions

data class User(
    val id: Int? = null,
    val name: String? = null,
    val about: String? = null,
    val avatar: UserAvatar? = null,
    val bannerImage: String? = null,
    val isFollowing: Boolean? = null,
    val isFollower: Boolean? = null,
    val isBlocked: Boolean? = null,
    val bans: Json? = null,
    val options: UserOptions? = null,
    val mediaListOptions: MediaListOptions? = null,
    val favourites: Favourites? = null,
    val statistics: UserStatisticTypes? = null,
    val unreadNotificationCount: Int? = null,
    val siteUrl: String? = null,
    val donatorTier: Int? = null,
    val donatorBadge: String? = null,
    val moderatorRoles: List<ModRole>? = null,
    val createdAt: Int? = null,
    val updatedAt: Int? = null,
    val previousNames: List<UserPreviousName>? = null
): DomainModel
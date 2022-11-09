package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.api.enums.StudioSort

data class StudioQuery(
    val id: Int? = null,
    val search: String? = null,
    val id_not: Int? = null,
    val id_in: List<Int>? = null,
    val id_not_in: List<Int>? = null,
    val sort: List<StudioSort>? = null
) : QueryParameter
package ru.glassnekeep.anilist.api.models.query

import ru.glassnekeep.anilist.api.enums.StaffSort

data class StaffQuery(
    val id: Int? = null,
    val isBirthday: Boolean? = null,
    val search: String? = null,
    val id_not: Int? = null,
    val id_in: List<Int>? = null,
    val id_not_in: List<Int>? = null,
    val sort: List<StaffSort>? = null
) : QueryParameter
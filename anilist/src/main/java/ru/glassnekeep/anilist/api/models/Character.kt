package ru.glassnekeep.anilist.api.models

import ru.glassnekeep.anilist.QueryParameter
import ru.glassnekeep.anilist.api.enums.CharacterSort

data class Character(
    val id: Int? = null,
    val isBirthday: Boolean? = null,
    val search: String? = null,
    val id_not: Int? = null,
    val id_in: List<Int>? = null,
    val id_not_in: List<Int>? = null,
    val sort: List<CharacterSort>? = null
) : QueryParameter
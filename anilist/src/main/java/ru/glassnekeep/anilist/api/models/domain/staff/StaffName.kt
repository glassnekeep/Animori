package ru.glassnekeep.anilist.api.models.domain.staff

data class StaffName(
    val first: String? = null,
    val middle: String ? = null,
    val last: String? = null,
    val full: String? = null,
    val native: String ? = null,
    val alternative: List<String>? = null,
    val userPreferred: String? = null
)
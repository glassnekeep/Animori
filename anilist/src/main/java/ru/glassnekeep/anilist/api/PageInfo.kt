package ru.glassnekeep.anilist.api

data class PageInfo(
    val total: Int? = null,
    val perPage: Int? = null,
    val currentPage: Int? = null,
    val lastPage: Int? = null,
    val hasNextPage: Boolean? = null
)
package ru.glassnekeep.media_data.models

data class AnimeDetail(
    val id: Int,
    val title: String,
    val type: String,
    val format: String,
    val status: String,
    val description: String,
    val startDate: String,
    val endDate: String,
    val season: String,
    val seasonYear: Int,
    val seasonInt: Int,
    val episodes: Int,
    val duration: Int,
    val volumes: Int? = null,
    val countryOfOrigin: String,
    val isLicensed: Boolean,
    val source: String,
    val hashtag: String? = null,
    val coverImage: String,
    val bannerImage: String,
    val genres: List<String>,
    val tags: List<String>,
    //relations
    //characters
    //studios
    val isAdult: Boolean,
    //recommendations
)

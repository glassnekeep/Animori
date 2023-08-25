package ru.glassnekeep.character_data.models

import ru.glassnekeep.media_data.models.AnimeDetail

data class CharacterDetail(
    val id: Int,
    val image: String,
    val firstName: String?,
    val middleName: String?,
    val lastName: String?,
    val fullName: String,
    val alternativeNames: List<String>,
    val alternativeSpoilerNames: List<String>,
    val description: String?,
    val gender: String?,
    val dateOfBirth: String?,
    val age: String?,
    val medias: List<AnimeDetail>
) {
    companion object {
        val EMPTY = CharacterDetail(
            id = 0,
            image = "",
            firstName = null,
            middleName = null,
            lastName = null,
            fullName = "",
            alternativeNames = emptyList(),
            alternativeSpoilerNames = emptyList(),
            description = null,
            gender = null,
            dateOfBirth = null,
            age = null,
            medias = emptyList(),
        )
    }
}

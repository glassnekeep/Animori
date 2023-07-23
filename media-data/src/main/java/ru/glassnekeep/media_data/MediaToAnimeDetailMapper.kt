package ru.glassnekeep.media_data

import android.os.Build
import ru.glassnekeep.anilist.api.models.domain.formFormattedDate
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.media_data.models.AnimeDetail
import ru.glassnekeep.media_data.use_cases.toLowerCaseWithFirstCapitalLetter

object MediaToAnimeDetailMapper {
    fun map(media: Media): AnimeDetail {
        return with(media) {
            AnimeDetail(
                id = id!!,
                title = title!!.english.toString(),
                type = type.toString().toLowerCaseWithFirstCapitalLetter(),
                format = format.toString().toLowerCaseWithFirstCapitalLetter(),
                status = status.toString().toLowerCaseWithFirstCapitalLetter(),
                description = description!!,
                startDate = startDate!!.let {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) it.formFormattedDate() else "${it.day}.${it.month}.${it.year}"
                },
                endDate = endDate!!.let {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) it.formFormattedDate() else "${it.day}.${it.month}.${it.year}"
                },
                season = season.toString().toLowerCaseWithFirstCapitalLetter(),
                seasonYear = seasonYear!!,
                seasonInt = seasonInt!!,
                episodes = episodes!!,
                duration = duration!!,
                volumes = volumes,
                countryOfOrigin = countryOfOrigin!!,
                isLicensed = isLicensed!!,
                source = source.toString().toLowerCaseWithFirstCapitalLetter(),
                hashtag = hashtag,
                coverImage = coverImage!!.large ?: coverImage!!.medium!!,
                bannerImage = bannerImage!!,
                genres = genres!!,
                tags = tags!!.map { it.name!! },
                characters = characters?.nodes ?: emptyList(),
                isAdult = isAdult!!
            )
        }
    }
}
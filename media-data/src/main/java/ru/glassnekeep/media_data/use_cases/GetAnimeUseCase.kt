package ru.glassnekeep.media_data.use_cases

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.withContext
import ru.glassnekeep.anilist.api.models.domain.FuzzyDate
import ru.glassnekeep.core.di.AppDispatchers
import ru.glassnekeep.core.di.AppScope
import ru.glassnekeep.media_data.MediaRepository
import ru.glassnekeep.media_data.models.AnimeDetail
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@AppScope
class GetAnimeUseCase @Inject constructor(
    private val mediaRepository: MediaRepository,
    private val dispatchers: AppDispatchers
) {
    suspend fun execute(id: Int): AnimeDetail {
        return withContext(dispatchers.io) {
            mediaRepository.getAnime(id).run {
                AnimeDetail(
                    id = id,
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
                    isAdult = isAdult!!
                )
            }
        }
    }

    private fun String.toLowerCaseWithFirstCapitalLetter(): String {
        return lowercase(Locale.ROOT).replaceFirstChar { if(it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun FuzzyDate.formFormattedDate(): String {
        val string = buildString {
            append(year)
            append("-")
            if (month != null && month!! > 9) append(month) else {
                append(0)
                append(month)
            }
            append("-")
            if (day != null && day!! > 9) append(day) else {
                append(0)
                append(day)
            }
        }
        val notFormattedDate = LocalDate.parse(string)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return notFormattedDate.format(formatter)
    }
}
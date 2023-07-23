package ru.glassnekeep.anilist.api.models.domain

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Serializable
data class FuzzyDate(
    val year: Int? = null,
    val month: Int? = null,
    val day: Int? = null
)

@RequiresApi(Build.VERSION_CODES.O)
fun FuzzyDate.formFormattedDate(): String {
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
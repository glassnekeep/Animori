package ru.glassnekeep.basic_ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult

@Composable
fun ExpandingText(
    modifier: Modifier,
    text: String,
    maxLines: Int
) {
    var isExpanded by remember { mutableStateOf(false) }
    var textLayoutResultState by remember { mutableStateOf<TextLayoutResult?>(null) }
    var isClickable by remember { mutableStateOf(false) }
    var finalText by remember { mutableStateOf(text) }

    val textLayoutResult = textLayoutResultState
    LaunchedEffect(textLayoutResult) {
        if (textLayoutResult == null) return@LaunchedEffect

        when {
            isExpanded -> {
                finalText = text
            }
            (!isExpanded && textLayoutResult.hasVisualOverflow) -> {
                val lastCharIndex = textLayoutResult.getLineEnd(maxLines - 1)
                val showMoreString = "..."
                val adjustText = text
                    .substring(startIndex = 0, endIndex = lastCharIndex)
                    .dropLast(showMoreString.length)
                    .dropLastWhile { it == ' ' || it == '.' }

                finalText = "$adjustText$showMoreString"

                isClickable = true
            }
        }
    }

    Text(
        text = finalText,
        maxLines = if (isExpanded) Int.MAX_VALUE else maxLines,
        onTextLayout = { textLayoutResultState = it },
        modifier = modifier
            .clickable(enabled = isClickable) { isExpanded = !isExpanded }
            .animateContentSize()
    )
}
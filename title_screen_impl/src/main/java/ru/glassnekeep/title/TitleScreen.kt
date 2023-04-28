package ru.glassnekeep.title

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.glassnekeep.design_system.theme.Typography

@Composable
fun TitleScreen(viewModel: TitleScreenViewModel, modifier: Modifier = Modifier) {
    CollapsableToolbar()
}

@OptIn(ExperimentalMotionApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun MotionComposeHeader(progress: Float, imageUrl: String, scrollableBody: @Composable () -> Unit) {
    MotionLayout(
        start = startConstraintSet(),
        end = endConstraintSet(),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        GlideImage(
            contentDescription = "Anime image",
            modifier = Modifier.layoutId("poster"),
            model = imageUrl,
            contentScale = ContentScale.FillWidth,
            alpha = 1f - progress,
        )
        Text(
            text = "Text",
            modifier = Modifier.layoutId("title").wrapContentHeight(),
            style = Typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Box(
            Modifier.layoutId("content")
        ) {
            scrollableBody()
        }
    }
}

@Composable
fun CollapsableToolbar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        //val animateToEnd by remember { mutableStateOf(true) }
        var animateToCollapsedState by remember { mutableStateOf(false) }
        val progress by animateFloatAsState(
            targetValue = if (animateToCollapsedState) 1f else 0f,
            animationSpec = tween(1000)
        )
        Column() {
            MotionComposeHeader(
                progress = progress,
                imageUrl = "https://s4.anilist.co/file/anilistcdn/media/anime/cover/small/bx1-CXtrrkMpJ8Zq.png"
            ) {
                //For now we pass no srollable content to header
            }
        }
        Button(
            onClick = { animateToCollapsedState = animateToCollapsedState.not() },
            Modifier
                .align(Alignment.BottomCenter)
                .padding(32.dp)
        ) {
            Text(text = if (!animateToCollapsedState) "Collapse" else "Expand")
        }
    }
}

private fun startConstraintSet() = ConstraintSet {
    val poster = createRefFor("poster")
    val title = createRefFor("title")
    val content = createRefFor("content")

    constrain(poster) {
        width = Dimension.fillToConstraints
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
    }

    constrain(title) {
        start.linkTo(parent.start, 16.dp)
        top.linkTo(poster.bottom, 16.dp)
    }

    constrain(content) {
        width = Dimension.fillToConstraints
        top.linkTo(title.bottom, 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
}

private fun endConstraintSet() = ConstraintSet {
    val poster = createRefFor("poster")
    val title = createRefFor("title")
    val content = createRefFor("content")

    constrain(poster) {
        width = Dimension.fillToConstraints
        height = Dimension.value(56.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        top.linkTo(parent.top)
    }

    constrain(title) {
        start.linkTo(parent.start)
        top.linkTo(parent.top, 8.dp)
        end.linkTo(parent.end)
        bottom.linkTo(poster.bottom)
    }

    constrain(content) {
        width = Dimension.fillToConstraints
        top.linkTo(poster.bottom, 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
}
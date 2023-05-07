package ru.glassnekeep.title

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.glassnekeep.basic_ui.ExpandingText
import ru.glassnekeep.design_system.theme.Dimens
import ru.glassnekeep.design_system.theme.Typography
import ru.glassnekeep.media_data.models.AnimeDetail

@Composable
fun TitleScreen(viewModel: TitleScreenViewModel, modifier: Modifier = Modifier) {
    CollapsableToolbar(viewModel)
}

@OptIn(ExperimentalMotionApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun MotionComposeHeader(
    progress: Float,
    imageUrl: String,
    title: String,
    scrollableBody: @Composable () -> Unit) {
    MotionLayout(
        start = startConstraintSet(),
        end = endConstraintSet(),
        progress = progress,
        modifier = Modifier.fillMaxSize()
    ) {
        GlideImage(
            contentDescription = "Anime image",
            modifier = Modifier
                .layoutId("poster")
                .heightIn(0.dp, 400.dp),
            model = imageUrl,
            contentScale = ContentScale.FillWidth,
            alpha = 1f - progress,
        )
        Text(
            text = title,
            modifier = Modifier
                .layoutId("title")
                .wrapContentHeight(),
            style = Typography.headlineLarge,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
        Box(
            Modifier.layoutId("content")
        ) {
            scrollableBody()
        }
    }
}

enum class SwipingStates {
    EXPANDED,
    COLLAPSED
}

@Composable
fun CollapsableToolbar(viewModel: TitleScreenViewModel) {
    val state = viewModel.state.collectAsState().value
    Scaffold(
        content = {
            when (state) {
                is TitleScreenViewModel.TitleState.Data -> {
                    DataState(state.data)
                }
                is TitleScreenViewModel.TitleState.Error -> {

                }
                is TitleScreenViewModel.TitleState.Loading -> {
                    LoadingState()
                }
                is TitleScreenViewModel.TitleState.NotFound -> {

                }
            }
    })
}

@Composable
private fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            strokeWidth = 4.dp,
            color = Color.Cyan,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DataState(
    anime: AnimeDetail,
) {
    val swipingState = rememberSwipeableState(initialValue = SwipingStates.EXPANDED)
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val heightInPx = with(LocalDensity.current) { maxHeight.toPx() }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .swipeable(
                    state = swipingState,
                    thresholds = { _, _ -> FractionalThreshold(0.5f) },
                    orientation = Orientation.Vertical,
                    anchors = mapOf(
                        0f to SwipingStates.COLLAPSED,
                        heightInPx to SwipingStates.EXPANDED,
                    )
                )
        ) {
            Column(
                modifier = Modifier
            ) {
                MotionComposeHeader(
                    progress = if (swipingState.progress.to == SwipingStates.COLLAPSED) swipingState.progress.fraction else 1f - swipingState.progress.fraction,
                    imageUrl = anime.coverImage,
                    title = anime.title
                ) {
                    Column(
                        modifier = Modifier
                            .padding(Dimens.verySmall)
                    ) {
                        Text(
                            textAlign = TextAlign.Center,
                            style = Typography.bodySmall,
                            modifier = Modifier,
                            text = Texts.SERIES
                        )
                        Row(
                            modifier = Modifier
                        ) {
                            repeat(5) {
                                Icon(
                                    imageVector = Icons.Outlined.Star,
                                    contentDescription = Texts.STAR,
                                    tint = MaterialTheme.colors.onBackground
                                )
                            }
                            Text(
                                textAlign = TextAlign.Center,
                                style = Typography.bodySmall,
                                modifier = Modifier
                                    .padding(Dimens.extraSmall)
                                ,
                                text = Texts.RATING
                            )
                        }
//                        Text(
//                            textAlign = TextAlign.Left,
//                            style = Typography.bodySmall,
//                            modifier = Modifier,
//                            text = anime.description,
//                            //maxLines = TextParams.MAX_LINES_DESCRIPTION,
//                            overflow = TextOverflow.Ellipsis,
//                        )
                        ExpandingText(
                            modifier = Modifier,
                            text = anime.description,
                            maxLines = TextParams.MAX_LINES_DESCRIPTION
                        )
                    }
                }
            }
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
        height = Dimension.value(48.dp)
    }

    constrain(content) {
        width = Dimension.fillToConstraints
        top.linkTo(poster.bottom, 8.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }
}
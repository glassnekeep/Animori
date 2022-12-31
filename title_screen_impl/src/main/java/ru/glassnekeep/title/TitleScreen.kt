package ru.glassnekeep.title

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.glassnekeep.design_system.theme.Typography

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CollapsingToolbarScreen(progress: Float, imageUrl: String, scrollableBody: @Composable () -> Unit) {
    MotionLayout(
        start = " ",
        end = " ",
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

private fun startConstraints() = ConstraintSet {
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
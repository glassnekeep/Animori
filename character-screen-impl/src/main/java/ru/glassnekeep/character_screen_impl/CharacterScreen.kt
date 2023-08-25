package ru.glassnekeep.character_screen_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.launch
import ru.glassnekeep.basic_ui.cards.SmallAnimeCard
import ru.glassnekeep.basic_ui.shimmer.shimmer
import ru.glassnekeep.character_data.models.CharacterDetail
import ru.glassnekeep.character_screen_impl.view_model.CharacterScreenViewModel
import ru.glassnekeep.design_system.theme.Dimens
import ru.glassnekeep.design_system.theme.Typography

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterScreenViewModel,
    modifier: Modifier = Modifier,
    cardOnClick: (CharacterDetail) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val state = viewModel.state.collectAsState().value
    Scaffold(
        content = {
            if (state.isLoading) {
                CharacterScreenCore(navController, modifier.shimmer(), cardOnClick)
            }
            state.data?.let { character ->
                CharacterScreenCore(navController, modifier = modifier, cardOnClick, character)
            } ?: state.errorMsg?.let { message ->
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(message)
                }
            }
        }
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterScreenCore(
    navController: NavController,
    modifier: Modifier,
    cardOnClick: (CharacterDetail) -> Unit,
    character: CharacterDetail = CharacterDetail.EMPTY,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
    ) {
        GlideImage(
            contentDescription = "Anime image",
            modifier = Modifier
                .heightIn(0.dp, 400.dp),
            model = character.image,
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = character.fullName,
            modifier = Modifier
                .wrapContentHeight()
                .padding(Dimens.small),
            style = Typography.headlineLarge,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Ellipsis
        )
        Row {
            Text(
                text = context.getString(R.string.character_name),
                modifier = Modifier.wrapContentHeight(),
                style = Typography.bodyMedium,
                textAlign = TextAlign.Left
            )
            character.alternativeNames.forEach { name ->
                Text(
                    text = name,
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = Dimens.extraSmall),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Left
                )
            }
        }
        Text(
            text = character.description ?: EMPTY_DESCRIPTION,
            modifier = Modifier
                .wrapContentHeight()
                .padding(Dimens.small),
            style = Typography.bodyMedium,
            textAlign = TextAlign.Left
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            character.medias.forEach {
                item {
                    SmallAnimeCard(
                        navController = navController,
                        destination = "",
                        cardOnClick = { cardOnClick(character) }
                    )
                }
            }
        }
    }
}

internal const val EMPTY_DESCRIPTION = ""
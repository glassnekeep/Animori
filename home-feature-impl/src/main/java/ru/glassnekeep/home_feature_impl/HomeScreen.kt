package ru.glassnekeep.home_feature_impl

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import ru.glassnekeep.basic_ui.cards.BigAnimeCard
import ru.glassnekeep.media_data.models.Anime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel,
    cardOnClick: (Anime) -> Unit,
) {
    val state = viewModel.state.collectAsState().value
    Scaffold(
        topBar = { HomeTopBar(title = "Home") },
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = it,
                content = {
                    if (state is HomeViewModel.HomeState.Data) {
                        state.data.forEach { anime ->
                            item {
                                BigAnimeCard(
                                    navController = navController,
                                    destination = "",
                                    description = anime.description,
                                    imageUrl = anime.image,
                                    title = anime.title,
                                    cardOnClick = { cardOnClick(anime) }
                                )
                            }
                        }
                    }
                })
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar(
    title: String,
    modifier: Modifier = Modifier,
) {
    TopAppBar(title = {
        Text(
            text = title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    },
    navigationIcon = {
        Icon(
            //TODO Тут, наверное, должна быть иконка самого нашего приложения
            imageVector = Icons.Filled.Circle,
            contentDescription = "Application's icon"
        )
    },
    actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Search icon on main screen"
            )
        }
    })
}


package ru.glassnekeep.home_feature_impl

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import ru.glassnekeep.basic_ui.BigAnimeCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val state = viewModel.state.collectAsState().value
    Scaffold(
        topBar = { HomeTopBar(title = "Home") },
        content = {
//            Column(modifier = Modifier.padding(it)) {
//                Text(text = "TEST MAIN TEXT", fontFamily = FontFamily.Serif)
//            }
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
                                    title = anime.title
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


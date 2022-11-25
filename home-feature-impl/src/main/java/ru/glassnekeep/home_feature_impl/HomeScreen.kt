package ru.glassnekeep.home_feature_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    Scaffold(
        topBar = { HomeTopBar(title = "Test") },
        content = {
            Column(modifier = Modifier.padding(it)) {
                Text(text = "TEST MAIN TEXT", fontFamily = FontFamily.Serif)
            }
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


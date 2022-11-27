package ru.glassnekeep.basic_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.design_system.theme.AnimoriTheme
import ru.glassnekeep.design_system.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BigAnimeCard(
    navController: NavController,
    destination: String,
    content: @Composable () -> Unit = { },
    cardOnClick: () -> Unit = { },
    iconOnCLick: () -> Unit = { }
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier
            .fillMaxWidth()
            //.padding(5.dp)
            .height(120.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Gray
        ),
        onClick = {

        }
    ) {
        Row(
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.magic_battle),
                contentDescription = "Magic battle image",
                modifier = Modifier.fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Магическая битва",
                    style = Typography.headlineMedium,
                    color = Color.White,
                )
                Text(
                    text = "Описание данного великолепного тайтла",
                    style = Typography.bodyMedium,
                    color = Color.White,
                    maxLines = 3,
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlaylistAdd,
                        contentDescription = " ",
                        tint = Color.White,
                        //modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewBigAnimeCard() {
    AnimoriTheme {
        BigAnimeCard(navController = rememberNavController(), destination = "")
    }
}
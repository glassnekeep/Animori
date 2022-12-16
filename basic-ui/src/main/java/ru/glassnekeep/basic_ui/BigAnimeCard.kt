package ru.glassnekeep.basic_ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ru.glassnekeep.design_system.theme.AnimoriTheme
import ru.glassnekeep.design_system.theme.Typography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun BigAnimeCard(
    navController: NavController,
    destination: String,
    content: @Composable () -> Unit = { },
    cardOnClick: () -> Unit = { },
    iconOnCLick: () -> Unit = { },
    imageUrl: String,
    title: String,
    description: String
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
            GlideImage(
                //painter = painterResource(id = R.drawable.magic_battle),
                contentDescription = "Anime image",
                modifier = Modifier.size(120.dp),
                model = imageUrl,
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
                    text = title,
                    style = Typography.headlineMedium,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = description,
                    style = Typography.bodyMedium,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.PlaylistAdd,
                        contentDescription = " ",
                        tint = Color.White,
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
        BigAnimeCard(
            navController = rememberNavController(),
            destination = "",
            description = "Мистические загадки с множеством неожиданных сюжетных поворотов, а также заклинания и призывы монстров представлены в аниме \"Jujutsu Kaisen\". Юдзи обязан спасти не только своих друзей от демонов, но и попытаться вновь заточить ужасного Рёмэн. Во всём пареньку будет помогать опытный экзорцист, который жаждет уничтожить всех сущностей из параллельного мира.",
            imageUrl = "",
            title = "Магическая битва"
        )
    }
}
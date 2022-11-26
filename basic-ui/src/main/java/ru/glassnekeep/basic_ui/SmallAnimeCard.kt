package ru.glassnekeep.basic_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.More
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.glassnekeep.design_system.theme.AnimoriTheme
import ru.glassnekeep.design_system.theme.Typography
import kotlin.text.Typography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallAnimeCard(
    navController: NavController,
    destination: String,
    content: @Composable () -> Unit = { }
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        //modifier = Modifier.wrapContentSize(),
        modifier = Modifier.width(120.dp),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.DarkGray
        ),
        onClick = {

        }
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.attack_on_titans),
                contentDescription = "Eighty Six title image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Атака титанов",
                style = Typography.bodySmall,
                color = Color.White,
                modifier = Modifier.padding(2.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
                ) {
                Text(
                    text = "Сериал",
                    color = Color.Cyan,
                    style = Typography.bodySmall
                )
                //Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = " ",
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSmallAnimeCard() {
    AnimoriTheme {
        SmallAnimeCard(navController = rememberNavController(), destination = "")
    }
}
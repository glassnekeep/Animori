package ru.glassnekeep.basic_ui.cards

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun CharacterCard(
    navController: NavController,
    destination: String,
    content: @Composable () -> Unit = { },
    cardOnClick: () -> Unit = { },
    imageUrl: String,
    name: String
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = Modifier
            .height(200.dp)
            .padding(6.dp)
            .widthIn(0.dp, 120.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Gray
        ),
        onClick = {
            cardOnClick()
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            GlideImage(
                contentDescription = "Character image",
                modifier = Modifier
                    .size(120.dp, 200.dp),
                model = imageUrl,
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                fontSize = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.BottomStart),
            )
        }
    }
}
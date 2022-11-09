package ru.glassnekeep.animori

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.glassnekeep.anilist.api.models.domain.media.MediaTitle
import ru.glassnekeep.anilist.api.enums.MediaType
import ru.glassnekeep.anilist.api.makeRequestString
import ru.glassnekeep.anilist.api.models.domain.PageInfo
import ru.glassnekeep.anilist.api.models.domain.media.Media
import ru.glassnekeep.anilist.api.models.query.MediaQuery
import ru.glassnekeep.anilist.api.models.query.PageQuery
import ru.glassnekeep.animori.di.LocalAppProvider
import ru.glassnekeep.animori.ui.theme.AnimoriTheme
import ru.glassnekeep.animori.ui.theme.md_theme_light_inversePrimary
import ru.glassnekeep.core.DevicePosture
import ru.glassnekeep.core.isBookPosture
import ru.glassnekeep.core.isSeparating
import ru.glassnekeep.profile_feature_impl.LocalProfileDataProvider
import ru.glassnekeep.user_data.LocalUserDataProvider

class MainActivity : ComponentActivity() {

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mediaQuery = MediaQuery(15125, type = MediaType.ANIME)
        val response = Media(id = 0, title = MediaTitle(english = " "))
        Log.d("Test", makeRequestString(
            query = mediaQuery,
            response = response,
            variables = emptyList(),
            page = PageQuery(page = 1, perPage = 20)
        ))
        val devicePictureFlow = WindowInfoTracker.getOrCreate(this).windowLayoutInfo(this)
            .flowWithLifecycle(this.lifecycle)
            .map { layoutInfo ->
                val foldingFeature = layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
                when {
                    isBookPosture(foldingFeature) -> DevicePosture.BookPosture(foldingFeature.bounds)
                    isSeparating(foldingFeature) -> DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)
                    else -> DevicePosture.NormalPosture
                }
            }
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = DevicePosture.NormalPosture
            )
//        setContent {
//            AnimoriTheme {
//                val windowSize = calculateWindowSizeClass(this)
//                val devicePosture by devicePictureFlow.collectAsState()
//                val uiState by viewModel.uiState.collectAsState()
//                App(
//                    windowSize = windowSize,
//                    foldingDevicePosture = devicePosture,
//                    replyHomeUIState = uiState,
//                    closeDetailScreen = { viewModel.closeDetailScreen() },
//                    navigateToDetail = { emailId, pane ->
//                        //viewModel.
//                    }
//                )
//            }
//        }

        setContent {
            AnimoriTheme {
                StatusBar(window, color = MaterialTheme.colorScheme.background)

                Surface(color = MaterialTheme.colorScheme.background) {
                    CompositionLocalProvider(
                        LocalAppProvider provides application.appProvider,
                        LocalProfileDataProvider provides application.appProvider,
                        LocalUserDataProvider provides application.appProvider
                    ) {
                        Navigation()
                    }
                }

                NavigationBar(window, color = md_theme_light_inversePrimary)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimoriTheme {
        Greeting("Android")
    }
}

@Composable
fun StatusBar(window: Window, color: Color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        DisposableEffect(color) {
            window.statusBarColor = color.toArgb()
            val isLight = color.luminance() > 0.5f
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility =
                if (isLight) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                else 0
            onDispose {}
        }
    }
}

@Composable
fun NavigationBar(window: Window, color: Color) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        DisposableEffect(color) {
            window.navigationBarColor = color.toArgb()
            val isLight = color.luminance() > 0.5f
            if (isLight) {
                @Suppress("DEPRECATION")
                window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or
                        View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
            onDispose {}
        }
    }
}
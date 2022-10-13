package ru.glassnekeep.home_feature_impl

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ru.glassnekeep.home_feature.HomeFeatureApi

class HomeFeatureImpl: HomeFeatureApi {

    private val homeRoute = "home"

    override fun homeRoute() = homeRoute

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(homeRoute) {
            HomeScreen(modifier = modifier, navController = navController)
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HomeScreen(modifier: Modifier, navController: NavController) {

    }
}
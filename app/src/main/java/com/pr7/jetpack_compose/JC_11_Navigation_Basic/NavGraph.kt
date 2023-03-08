package com.pr7.jetpack_compose.JC_11_Navigation_Basic

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pr7.jetpack_compose.JC_11_Navigation_Basic.screens.DetailScreen
import com.pr7.jetpack_compose.JC_11_Navigation_Basic.screens.HomeScreen


@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController,
    startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navHostController)
        }
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navHostController)
        }
    }
}
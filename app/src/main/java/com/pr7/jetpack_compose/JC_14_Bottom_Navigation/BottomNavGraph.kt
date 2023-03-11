package com.pr7.jetpack_compose.JC_14_Bottom_Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens.BottomBarScreens
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens.HomeScreen
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens.ProfileScreen
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens.SettingsScreen


@Composable
fun BottomNavGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomBarScreens.Home.route
    ){

        composable(route = BottomBarScreens.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreens.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreens.Settings.route){
            SettingsScreen()
        }
    }
}
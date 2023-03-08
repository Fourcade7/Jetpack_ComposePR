package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens.AdobeScreen
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens.NameScreens
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens.YoutubeScreen


@Composable
fun ControlNavs(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination =  NameScreens.Adobe.route){
        composable(NameScreens.Adobe.route){
            AdobeScreen(navController)
        }
        composable(NameScreens.Youtube.route){
            YoutubeScreen(navController)
        }
    }
}
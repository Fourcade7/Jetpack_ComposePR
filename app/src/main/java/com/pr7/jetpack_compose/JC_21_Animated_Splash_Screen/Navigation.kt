package com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens.Screens
import com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens.animatedSplash
import com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens.homeScreen
import com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens.splashScreen


@Composable
fun setupNav(
    navHostController: NavHostController
) {

    NavHost(navController = navHostController,
        startDestination = Screens.Splash.route ){
        composable(route = Screens.Splash.route){
            animatedSplash(navHostController = navHostController)
        }
        composable(route = Screens.Home.route){
            homeScreen()
        }
    }


}
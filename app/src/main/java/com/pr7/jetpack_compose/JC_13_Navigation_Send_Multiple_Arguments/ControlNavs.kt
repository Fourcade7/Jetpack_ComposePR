package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens.*


@Composable
fun ControlNavs(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NameScreens.Adobe.route
    ) {
        composable(NameScreens.Adobe.route) {
            AdobeScreen(navController)
        }
        composable(
            route = NameScreens.Youtube.route,
            arguments = listOf(
                navArgument("$ARGUMENT_KEY") {
                    type = NavType.IntType
                },
                navArgument("$ARGUMENT_KEY2") {
                    type = NavType.StringType
                }

            )
        ) {
            Log.d("PR77777", "ControlNavs: ${it.arguments?.getInt("$ARGUMENT_KEY")}")
            Log.d("PR77777", "ControlNavs: ${it.arguments?.getString("$ARGUMENT_KEY2")}")
            YoutubeScreen(navController, it.arguments?.getInt("$ARGUMENT_KEY ")!!,"${it.arguments?.getString("$ARGUMENT_KEY2")}")
        }
    }
}
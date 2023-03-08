package com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.screens.DETAIL_ARGUMENT_KEY
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.screens.GoogleScreen
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.screens.Scrrens
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.screens.YandexScreen


@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Scrrens.Google.route
    ){
       composable(
          route= Scrrens.Google.route
       ){
           GoogleScreen(navHostController)
       }
        composable(
           route= Scrrens.Yandex.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENT_KEY){
                type= NavType.IntType
            })
        ){
            YandexScreen(navHostController)
            Log.d("PR77777", "SetupNavGraph: ${it.arguments?.getInt(DETAIL_ARGUMENT_KEY)}")
        }
    }

}
package com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens

sealed class Screens constructor(val route:String){
    object Home:Screens(route = "home_screen")
    object Splash:Screens(route = "splash_screen")
}

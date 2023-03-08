package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens



sealed class NameScreens constructor(val route:String){
    object Youtube:NameScreens("youtube_screen")
    object Adobe:NameScreens("adobe_screen")
}
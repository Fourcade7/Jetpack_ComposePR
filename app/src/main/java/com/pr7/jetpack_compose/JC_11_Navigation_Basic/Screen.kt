package com.pr7.jetpack_compose.JC_11_Navigation_Basic

sealed class Screen(val route:String){
    object Home:Screen(route = "home_screen")
    object Detail:Screen(route = "detail_screen")
}

package com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens constructor(
    val route:String,
    val title:String,
    val icon:ImageVector,
) {
    object Home:BottomBarScreens(
        route = "home",
        title = "home",
        icon =Icons.Default.Home
    )
    object Profile:BottomBarScreens(
        route = "profile",
        title = "profile",
        icon =Icons.Default.Person
    )
    object Settings:BottomBarScreens(
        route = "settings",
        title = "settings",
        icon =Icons.Default.Settings
    )
}
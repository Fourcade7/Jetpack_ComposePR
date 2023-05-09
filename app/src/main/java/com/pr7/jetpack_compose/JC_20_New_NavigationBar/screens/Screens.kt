package com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens constructor(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : Screens(
        route = "home_screen",
        title = "Home",
        icon =Icons.Default.Home
    )
    object Profile : Screens(
        route = "profile_screen",
        title = "Profile",
        icon =Icons.Default.Person
    )
    object Settings : Screens(
        route = "settings_screen",
        title = "Settings",
        icon =Icons.Default.Settings
    )
}

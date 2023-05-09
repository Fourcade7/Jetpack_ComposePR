package com.pr7.jetpack_compose.JC_20_New_NavigationBar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens.Screens
import com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens.homeScreen
import com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens.profileScreen
import com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens.settingsScreen


@Composable
fun RowScope.addItem(
    screens: Screens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {

    NavigationBarItem(
        label = {
            Text(text = screens.title)
        },
        icon = {
            Icon(imageVector = screens.icon, contentDescription = "")
        },
        selected = currentDestination?.hierarchy?.any { it.route == screens.route } == true,
        onClick = {
            navHostController.navigate(screens.route)
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            selectedTextColor = Color.Black,
            indicatorColor = Color.DarkGray,
            unselectedIconColor = Color.Gray,
            unselectedTextColor = Color.Gray
        ),



    )
}

@Composable
fun BottomBar(navHostController: NavHostController) {

    val screens = listOf(
        Screens.Home,
        Screens.Profile,
        Screens.Settings,
    )

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.Red
    ) {
        screens.forEach {
            addItem(
                screens = it,
                currentDestination = currentDestination,
                navHostController = navHostController
            )
        }
    }

}

@Composable
fun bottomNavGraphSetup(
    navHostController: NavHostController
) {


    NavHost(navController = navHostController, startDestination = Screens.Home.route ){
        composable(route = Screens.Home.route){ homeScreen()}
        composable(route = Screens.Profile.route){ profileScreen()}
        composable(route = Screens.Settings.route){ settingsScreen()}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun mainScreen() {


    val navController = rememberNavController()
    Scaffold(
        bottomBar ={ BottomBar(navHostController = navController)}
    ) {
        bottomNavGraphSetup(navHostController = navController)
    }
}
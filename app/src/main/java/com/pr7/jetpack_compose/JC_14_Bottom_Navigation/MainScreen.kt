package com.pr7.jetpack_compose.JC_14_Bottom_Navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens.BottomBarScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navHostController = navController)}
    ) {
        BottomNavGraph(navHostController = navController)
    }
    
}

@Composable
fun BottomBar(navHostController: NavHostController) {

    val screns= listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Profile,
        BottomBarScreens.Settings,
    )
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val curreentDestination= navBackStackEntry?.destination
    
    BottomNavigation(modifier = Modifier.size(300.dp)) {

        screns.forEach { screns->
            AddItem(screens = screns, currentDestination = curreentDestination, navHostController = navHostController)
        }
        
    }

}

@Composable
fun RowScope.AddItem(
    screens: BottomBarScreens,
    currentDestination: NavDestination?,
    navHostController: NavHostController
) {
  BottomNavigationItem(
      label = {
              Text(text = screens.title)
      },
      icon = {
             Icon(imageVector = screens.icon, contentDescription = "")
      },
      onClick = {
                navHostController.navigate(screens.route){
                    popUpTo(navHostController.graph.findStartDestination().id)
                    launchSingleTop=true
                }
      },
      selected = currentDestination?.hierarchy?.any{it.route==screens.route}==true,
      unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)

  )
}
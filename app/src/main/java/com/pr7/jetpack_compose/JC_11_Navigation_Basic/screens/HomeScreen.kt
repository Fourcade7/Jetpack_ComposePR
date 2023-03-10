package com.pr7.jetpack_compose.JC_11_Navigation_Basic.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.pr7.jetpack_compose.JC_11_Navigation_Basic.Screen


@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = "Home",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.route)
            }
        )
    }

}
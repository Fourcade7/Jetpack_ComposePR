package com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.pr7.jetpack_compose.ui.theme.Purple700
import kotlinx.coroutines.delay


@Composable
fun animatedSplash(navHostController: NavHostController) {
    var startanimation by remember {
        mutableStateOf(false)
    }
    val alphaanim by animateFloatAsState(
        targetValue = if (startanimation)1f else 0f,
        animationSpec = tween(3000)
    )

    LaunchedEffect(key1 = true ){
        startanimation=true
        delay(4000)
        navHostController.navigate(Screens.Home.route)
    }

    splashScreen(alphaanim)
}


@Composable
fun splashScreen(alpha:Float) {
    
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Purple700)
            .fillMaxSize()
            .alpha(alpha = alpha)
    ) {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = "",
            tint = Color.LightGray,
            modifier = Modifier.size(120.dp)
        )
    }
}
package com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.ui.theme.Purple700


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homeScreen() {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.background(Color.White).fillMaxSize()
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "",
            tint = Color.DarkGray,
            modifier = Modifier.size(120.dp)
        )
    }
}

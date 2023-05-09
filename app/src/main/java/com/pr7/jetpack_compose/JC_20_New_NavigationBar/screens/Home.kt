package com.pr7.jetpack_compose.JC_20_New_NavigationBar.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun homeScreen() {
    Column(
        verticalArrangement =Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Home",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
    }
}
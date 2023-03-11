package com.pr7.jetpack_compose.JC_14_Bottom_Navigation.screens

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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Settings",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )
    }
}
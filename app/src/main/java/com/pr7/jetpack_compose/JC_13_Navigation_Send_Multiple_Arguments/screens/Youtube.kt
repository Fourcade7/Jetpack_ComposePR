package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.ui.theme.YoutubeCustomColor


@Composable
fun YoutubeScreen(
    navHostController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Youtube",
            color = YoutubeCustomColor,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.clickable {
            navHostController.popBackStack()
            }
        )
    }
}

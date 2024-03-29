package com.pr7.jetpack_compose.JC_14_Bottom_Navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.JC_14_Bottom_Navigation.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            prmainscren()
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prmainscren() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "This is Bottom Navigation")
        MainScreen()
    }
}


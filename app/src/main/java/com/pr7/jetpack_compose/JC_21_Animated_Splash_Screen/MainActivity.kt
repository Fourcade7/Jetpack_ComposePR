package com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_21_Animated_Splash_Screen.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController= rememberNavController()
            setupNav(navHostController = navHostController)
        }

        Log.d("PR77777", "onCreate: PR7777")
        Toast.makeText(this@MainActivity,"ishlidi axir",Toast.LENGTH_SHORT).show()
    }
}


package com.pr7.jetpack_compose.JC_11_Navigation_Basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_11_Navigation_Basic.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {

            navHostController= rememberNavController()
            SetupNavGraph(navHostController = navHostController)
            }
        }
    }
}

@Preview
@Composable
fun prnavigationbasic() {
    
}


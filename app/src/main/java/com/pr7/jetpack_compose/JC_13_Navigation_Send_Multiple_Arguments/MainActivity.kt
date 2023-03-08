package com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pr7.jetpack_compose.JC_13_Navigation_Send_Multiple_Arguments.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        mainscreen()
        }
    }
}
@Composable
fun mainscreen(){
  val  navHostController= rememberNavController()
  Column(modifier = Modifier.size(300.dp)) {
      ControlNavs(navController = navHostController)

  }
}

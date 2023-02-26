package com.pr7.jetpack_compose.JC_1_Column_and_Row

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_1_Column_and_Row.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_1_Column_and_Row.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prcolumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        //verticalArrangement = Arrangement.SpaceAround,
        //verticalArrangement = Arrangement.spacedBy(10.dp),

    ) {
        Text(text = "Fourcade")
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Aminov")
        Surface(
            modifier = Modifier.size(150.dp),
            color = Color.LightGray,
            shape = Shapes.medium
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Jetpack Compose")
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prrow() {

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Android Studio", fontSize = 40.sp)
        Text(text = "Android Studio", fontSize = 40.sp)
    }
    
}

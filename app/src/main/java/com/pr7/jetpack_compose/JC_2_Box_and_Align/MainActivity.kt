package com.pr7.jetpack_compose.JC_2_Box_and_Align

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_2_Box_and_Align.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_2_Box_and_Align.ui.theme.Purple500
import com.pr7.jetpack_compose.JC_2_Box_and_Align.ui.theme.Shapes

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
fun prbox() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Purple500),
            contentAlignment = Alignment.Center
        ){
        Text(text = "Uaxaxax")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prbox2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = Color.LightGray,
            shape = RoundedCornerShape(10.dp)
        ) {

            Box(
                modifier = Modifier.size(150.dp),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Uaxaxax")
            }
        }
    }
}

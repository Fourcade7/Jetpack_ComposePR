package com.pr7.jetpack_compose.JC_16_Circular_Shape_Image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_16_Circular_Shape_Image.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R

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
                    prcircularshapeimageview()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prcircularshapeimageview() {
    Column() {
        Image(

            painter = painterResource(id = R.drawable.img),
            contentDescription ="",
            modifier = Modifier
                .size(150.dp)
                //.clip(CircleShape),
                .clip(RoundedCornerShape(size = 50.dp))
                .border(width = 3.dp, color = Color.Magenta, shape = RoundedCornerShape(50.dp)),
            contentScale = ContentScale.Crop
        )
    }

}
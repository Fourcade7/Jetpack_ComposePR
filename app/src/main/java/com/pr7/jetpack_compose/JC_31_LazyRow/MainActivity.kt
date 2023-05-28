package com.pr7.jetpack_compose.JC_31_LazyRow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_2_Box_and_Align.ui.theme.Shapes
import com.pr7.jetpack_compose.JC_31_LazyRow.ui.theme.CardviewBackground
import com.pr7.jetpack_compose.JC_31_LazyRow.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                mainscreenlazyrow()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun lazyitem() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                //.background(Color.LightGray),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.background(CardviewBackground).fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.adobe),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Adobe", textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun mainscreenlazyrow() {
    LazyRow(){
        items(10,key = null){
            lazyitem()
        }
    }

}
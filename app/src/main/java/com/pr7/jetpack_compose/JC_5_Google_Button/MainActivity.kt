package com.pr7.jetpack_compose.JC_5_Google_Button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_5_Google_Button.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_5_Google_Button.ui.theme.Shapes

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
                prgooglebutton()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prgooglebutton() {
    var visibleprogressbar by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Surface(
            modifier = Modifier
                .wrapContentSize()
                .padding(15.dp),
            color = Color.White,
            shape = Shapes.medium,
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            onClick = {
                visibleprogressbar=!visibleprogressbar
            }
        ) {
            Row(modifier = Modifier
                .padding(end = 10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = com.pr7.jetpack_compose.R.drawable.google),
                    contentDescription = "",
                    modifier = Modifier.size(44.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "Sign in with Google",
                )
                Spacer(modifier = Modifier.width(15.dp))
                Box(modifier = Modifier
                    //.background(Color.LightGray)
                    //or.weight(1f)
                    .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd


                ){
                    if (visibleprogressbar){
                        CircularProgressIndicator(modifier = Modifier.size(30.dp))
                        // modifier = Modifier.clip(CircleShape).align(Alignment.CenterEnd)
                    }
                }

            }
        }
    }
}
package com.pr7.jetpack_compose.JC_44_CustomLayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_44_CustomLayout.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            clayout()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun clayout() {

    Column() {

        Box(

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart

        ) {

            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.firebase),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }
            Row() {
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.yandex),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }
            Row() {
                Spacer(modifier = Modifier.width(60.dp))
                Image(
                    painter = painterResource(id = R.drawable.youtube),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }
            Row() {
                Spacer(modifier = Modifier.width(75.dp))
                Image(
                    painter = painterResource(id = R.drawable.swift),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }
            Row() {
                Spacer(modifier = Modifier.width(85.dp))
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }
            Row() {
                Spacer(modifier = Modifier.width(130.dp))
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Adobe",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.LightGray, shape = CircleShape),
                    contentScale = ContentScale.Crop,

                    )
            }


        }
    }
}
package com.pr7.jetpack_compose.JC_18_New_Lazy_Column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_18_New_Lazy_Column.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                prnewlazycolumn()

                }
            }
        }
    }
}



@ExperimentalFoundationApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prnewlazycolumn() {

    var items by remember {
        mutableStateOf(listOf(
            "Kotlin",
            "Java",
            "Python",
            "Go",
            "C++",

        ))
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(items=items, key = {it}){
            Text(
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray.copy(alpha = 0.2f))
                    .padding(15.dp)
                    .animateItemPlacement(
                        animationSpec = tween(
                            durationMillis = 600
                        )
                    ),
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                onClick = { items=items.shuffled()}
            ) {
                Text(
                    text = "Shuffle"
                )
            }
        }
    }

}
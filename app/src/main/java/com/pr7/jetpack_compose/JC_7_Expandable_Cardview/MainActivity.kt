package com.pr7.jetpack_compose.JC_7_Expandable_Cardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_7_Expandable_Cardview.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_7_Expandable_Cardview.ui.theme.Shapes

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
                    prexpandablecardview()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prexpandablecardview() {

    var clicked by remember {
        mutableStateOf(false)
    }
    val rotate by animateFloatAsState(
        targetValue = if (clicked) 180f else 0f
    )
  
    Column() {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        //animation start time
                        delayMillis = 0,
                        easing = LinearOutSlowInEasing
                    )
                ),
            shape = Shapes.medium,
            backgroundColor = Color.LightGray,
            onClick = {
                clicked=!clicked
            }

        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Text(
                        modifier = Modifier.weight(6f),
                        text = "Go"
                    )
                    IconButton(
                        modifier = Modifier.weight(1f).rotate(rotate),
                        onClick = {  clicked=!clicked }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowDropDown,"")

                    }

                }
                if (clicked){
                    Text(text = "Axaxxa ".repeat(50))
                }
            }

        }
    }

}
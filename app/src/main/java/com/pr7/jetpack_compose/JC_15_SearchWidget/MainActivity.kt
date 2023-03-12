package com.pr7.jetpack_compose.JC_15_SearchWidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_15_SearchWidget.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    var clicked=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                prcustomsearch()
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prcustomsearch() {

    var clicked by remember {
        mutableStateOf(true)
    }

   
   Box() {

       if (clicked){
           Row(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(60.dp)
                   .background(MaterialTheme.colors.primary)
                   .padding(15.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Text(
                   modifier = Modifier.weight(9f),
                   text = "Home",
                   fontSize = MaterialTheme.typography.h6.fontSize,
                   color = Color.White,

                   )
               IconButton(
                   modifier = Modifier.weight(1f),
                   onClick = {
                    clicked=false
                   }
               ) {
                   Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = Color.White)
               }
           }
       }else{
           Column(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(60.dp)
                   .background(MaterialTheme.colors.primary),
               verticalArrangement = Arrangement.Center

           ) {
               TextField(
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(MaterialTheme.colors.primary),
                   value = "",
                   onValueChange = {},
                   trailingIcon = {
                       IconButton(onClick = {
                           clicked=true
                       }) {
                           Icon(imageVector = Icons.Default.Close, contentDescription ="" , tint = Color.LightGray)
                       }
                   },
                   leadingIcon = {
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(imageVector = Icons.Default.Search, contentDescription ="",  tint = Color.LightGray)
                       }
                   },
                   placeholder = {
                       Text(
                           text = "Search",
                           color = Color.LightGray
                       )
                   },
                   colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
               )
           }
       }


    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun prcustomsearch2() {
//    Column() {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(60.dp)
//                .background(MaterialTheme.colors.primary),
//            verticalArrangement = Arrangement.Center
//
//        ) {
//            TextField(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(MaterialTheme.colors.primary),
//                value = "",
//                onValueChange = {},
//                trailingIcon = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.Close, contentDescription ="" , tint = Color.LightGray)
//                    }
//                },
//                leadingIcon = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Default.Search, contentDescription ="",  tint = Color.LightGray)
//                    }
//                },
//                placeholder = {
//                    Text(
//                        text = "Search",
//                        color = Color.LightGray
//                    )
//                }
//            )
//        }
//
//    }
//}




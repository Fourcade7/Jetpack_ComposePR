@file:OptIn(ExperimentalMaterial3Api::class)

package com.pr7.jetpack_compose.JC_43_Custom_TextField

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        customtextfield()
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun customtextfield() {

    var myval by remember {
        mutableStateOf("")
    }
    TextField(
        value = myval,
        onValueChange ={myval=it },
        shape = ShapeDefaults.Medium,
        colors = TextFieldDefaults.textFieldColors(

            textColor = Color.DarkGray,
            disabledTextColor = Color.DarkGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            containerColor = Color.DarkGray
        ),



    )

}
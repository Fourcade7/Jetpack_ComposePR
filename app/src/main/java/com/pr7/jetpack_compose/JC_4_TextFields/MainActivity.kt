package com.pr7.jetpack_compose.JC_4_TextFields

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_4_TextFields.ui.theme.Jetpack_ComposeTheme
import java.net.PasswordAuthentication

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
                    prtextfieldpassword()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prtextfields() {
    var name by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = "Name")
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            maxLines = 1,
            singleLine = true
        )
        Text(text = name)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prtextfieldcharacterlimits() {
    var name by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(15.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = {
                if (it.length < 10) {
                    name = it
                }
            },
            label = {
                Text(text = "Name")
            },
            placeholder = {
                Text(text = "Name")
            },
            maxLines = 1,
            singleLine = true
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prtextfieldpassword() {
    var name by remember {
        mutableStateOf("")
    }
    var pvisiblity by remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.padding(15.dp)) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = {
                Text(text = "8 character reuqired")
            },
            label = {
                Text(text = "Password")
            },
            singleLine = true,
            maxLines = 1,

            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    pvisiblity=!pvisiblity
                }) {
                    if (pvisiblity){
                        Icon(painter = painterResource(id = com.pr7.jetpack_compose.R.drawable.baseline_visibility_24), contentDescription = "")

                    }else{
                        Icon(painter = painterResource(id = com.pr7.jetpack_compose.R.drawable.baseline_visibility_off_24), contentDescription = "")

                    }
                }
            },
            visualTransformation = if (pvisiblity) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )
    }
}
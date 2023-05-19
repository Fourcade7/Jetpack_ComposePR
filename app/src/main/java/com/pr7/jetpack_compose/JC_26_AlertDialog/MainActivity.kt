package com.pr7.jetpack_compose.JC_26_AlertDialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_26_AlertDialog.ui.theme.Jetpack_ComposeTheme

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
                    pralertdialog()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun pralertdialog() {
    Jetpack_ComposeTheme {
        Column() {
            var openDialog by remember { mutableStateOf(false) }

            Button(onClick = {
                openDialog = true
            }) {
                Text("Click me")
            }

            if (openDialog) {
                AlertDialog(
                   // modifier = Modifier.clip(RoundedCornerShape(8.dp)), // corner rounded//not working
                    onDismissRequest = {

                    },
                    title = { Text(text = "Dialog Title") },
                    text = { Text(text = "Here is text") },
                    confirmButton = {
                        Button(onClick = { openDialog = false}) {
                            Text(text = "Click Me")
                        }
                    },
                    dismissButton = {

                    }
                )
            }
        }


    }
}
package com.pr7.jetpack_compose.JC_29_Spinner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_29_Spinner.ui.theme.Jetpack_ComposeTheme

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
                    mainspinner()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun mainspinner() {
    var outlinetextfield1 by remember {
        mutableStateOf("")
    }
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    val arraylistregions = arrayOf(
        "Toshkent",
        "Sirdaryo",
        "Samarqand",
        "Buxoro",
        "Jizzax",
    )
    Column(modifier = Modifier.padding(15.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = outlinetextfield1,
            onValueChange = {
                outlinetextfield1 = it
            },
            label = {
                androidx.compose.material.Text(text = "Regions")
            },
            placeholder = {
                androidx.compose.material.Text(text = "Note Desctiption")
            },
            maxLines = 1,
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.List, contentDescription = "list")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    menuExpanded = !menuExpanded
                }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "down")
                }
                DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                    DropdownMenuItem(
                        text = {
                            Column() {
                            arraylistregions.forEachIndexed { index, s ->
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Box(modifier = Modifier.width(500.dp).clickable {
                                        outlinetextfield1=arraylistregions.get(index)
                                        menuExpanded=false
                                    }) {
                                        Text(
                                            text = s,
                                            fontSize = 22.sp
                                        )
                                        Icon(
                                            imageVector = Icons.Default.LocationOn,
                                            contentDescription = "down",
                                            modifier = Modifier.align(Alignment.CenterEnd)
                                        )
                                    }
                            }

                            }

                        },
                        onClick = {

                        }
                    )

                }


            }

        )
    }
}


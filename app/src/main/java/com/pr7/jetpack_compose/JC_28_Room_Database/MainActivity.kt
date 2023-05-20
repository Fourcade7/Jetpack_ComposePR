@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.pr7.jetpack_compose.JC_28_Room_Database

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.AppDatabase
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.User
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.UserDao
import com.pr7.jetpack_compose.JC_28_Room_Database.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_28_Room_Database.ui.theme.Purple40
import com.pr7.jetpack_compose.JC_28_Room_Database.ui.theme.TopAppBarColor
import com.pr7.jetpack_compose.JC_28_Room_Database.viewmodel.UserViewModel
import com.pr7.jetpack_compose.ui.theme.Shapes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var userDao: UserDao
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userDao= AppDatabase.getInstance(this@MainActivity).userDao()

        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var arraylistremember by remember {
                        mutableStateOf(ArrayList<User>())
                    }
                    Log.d("PR77777", "onCreate: ")
                    //userViewModel.save(User(uid = 0, name = "Pr ", surname = "Deana Roach"))
                    userViewModel.getAllUsersconvert().observe(this@MainActivity,{
                       // Log.d("PR77777", "onCreate: pr ${it.get(10).name}")
                        arraylistremember=it as ArrayList<User>

                    })
                    mainroomview(arrayList = arraylistremember,userViewModel)
                }
            }
        }





    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun mainroompreview() {
    //mainroomview(arrayList =ArrayList<User>(),us)
}
//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun mainroomview(arrayList: ArrayList<User>,userViewModel: UserViewModel) {
    var menuExpanded by remember {
        mutableStateOf(false)
    }
    var openDialog by remember { mutableStateOf(false) }
    var outlinetextfield1 by remember {
        mutableStateOf("")
    }
    var outlinetextfield2 by remember {
        mutableStateOf("")
    }
    Column() {
        TopAppBar(

            title = {
                Text(
                    text = "Note Aapp",
                    color = Color.White
                )
            },
            actions = {
                IconButton(onClick = {menuExpanded=!menuExpanded }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Home",
                        tint = Color.White
                    )
                }

                DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded=false}) {
                    DropdownMenuItem(onClick = {


                            userViewModel.deleteAlluser()
                            menuExpanded=false

                    }) {
                        Text(text = "Delete All")
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.DarkGray
                        )
                    }
                    DropdownMenuItem(onClick = {

                    }) {
                        Text(text = "Info")
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Info",
                            tint = Color.DarkGray
                        )
                    }
                }
            },
            modifier = Modifier.background(TopAppBarColor),
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = TopAppBarColor)

        )

        Box(modifier = Modifier.fillMaxSize()){
            lazyroomview(arrayList = arrayList)
            FloatingActionButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(15.dp),
                onClick = {
                   openDialog=!openDialog
                },
                containerColor = Purple40,
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add FAB",
                    tint = Color.White,
                )
            }
        }
        if (openDialog) {
            AlertDialog(
                // modifier = Modifier.clip(RoundedCornerShape(8.dp)), // corner rounded//not working
                onDismissRequest = {
                    openDialog=false
                },
                title = { Text(text = "Add new Note") },
                text = {
                    Column() {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = outlinetextfield1,
                            onValueChange = {
                               outlinetextfield1=it
                            },
                            label = {
                                Text(text = "Title")
                            },
                            placeholder = {
                                Text(text = "Note title")
                            },
                            maxLines = 1,
                            singleLine = true
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = outlinetextfield2,
                            onValueChange = {
                                outlinetextfield2=it
                            },
                            label = {
                                androidx.compose.material.Text(text = "Description")
                            },
                            placeholder = {
                                androidx.compose.material.Text(text = "Note Desctiption")
                            },
                            maxLines = 1,
                            singleLine = true
                        )
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                        openDialog = false
                        userViewModel.save(user = User(0,outlinetextfield1,outlinetextfield2))
                        }
                    ) {
                        Text(text = "Click Me")
                    }
                },
                dismissButton = {

                }
            )
        }
    }
}

@Composable
fun lazyroomview(arrayList: ArrayList<User>) {
    LazyColumn(  verticalArrangement = Arrangement.spacedBy(6.dp) ){
        itemsIndexed(arrayList){index, item ->
            itemroomview(user = item)
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun itemroomview(user:User) {
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(2.dp),
            shape = Shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
            )
        ) {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = "id:${user.uid}",
                    modifier = Modifier.align(alignment = CenterVertically),
                    fontSize = 25.sp,

                )
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(
                        text = "${user.name}",
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "${user.surname}",
                    )
                }

            }

        }
    }
}





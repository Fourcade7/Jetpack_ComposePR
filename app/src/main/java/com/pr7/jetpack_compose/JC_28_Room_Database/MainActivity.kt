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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import com.pr7.jetpack_compose.JC_28_Room_Database.viewmodel.UserViewModel
import com.pr7.jetpack_compose.ui.theme.Shapes

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
                    userViewModel.save(User(uid = 0, name = "Guillermo Maddox", surname = "Deana Roach"))
                    userViewModel.getAllUsersconvert().observe(this@MainActivity,{
                        Log.d("PR77777", "onCreate: pr ${it.get(10).name}")
                        arraylistremember=it as ArrayList<User>

                    })
                    mainroomview(arrayList = arraylistremember)
                }
            }
        }





    }
}


//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun mainroomview(arrayList: ArrayList<User>) {
    Column() {
        Box(modifier = Modifier.fillMaxSize()){
            lazyroomview(arrayList = arrayList)
            FloatingActionButton(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .padding(15.dp),
                onClick = {
                    //OnClick Method
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





package com.pr7.jetpack_compose.JC_28_Room_Database

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.AppDatabase
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.User
import com.pr7.jetpack_compose.JC_28_Room_Database.data.room.UserDao
import com.pr7.jetpack_compose.JC_28_Room_Database.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    lateinit var userDao: UserDao
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

                }
            }
        }


    }
}




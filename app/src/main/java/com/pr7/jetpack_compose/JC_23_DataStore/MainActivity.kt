

package com.pr7.jetpack_compose.JC_23_DataStore

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceDataStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.pr7.jetpack_compose.JC_23_DataStore.ui.theme.Jetpack_ComposeTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


lateinit var dataStoreManager:DataStoreManager

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {


    //lateinit var datastore:DataStore<Preferences>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreManager=DataStoreManager(this@MainActivity)
        setContent {

            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                        mainScreen()


                }
            }
        }



    }

}



@ExperimentalMaterial3Api
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun mainScreen() {
    var textfield by remember {
        mutableStateOf("")
    }
    var textfield2 by remember {
        mutableStateOf("")
    }
    var textfield3 by remember {
        mutableStateOf("")
    }
    var loaddata by remember {
        mutableStateOf("")
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)) {
        Column() {
            OutlinedTextField(
                value = textfield,
                onValueChange ={
                    textfield=it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter key")}

            )
            OutlinedTextField(
                value = textfield2,
                onValueChange ={
                    textfield2=it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter value")}

            )
            Button(
                onClick = {

                    GlobalScope.launch {
                        dataStoreManager.save(key = textfield, value = textfield2)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .height(55.dp)
            ) {
                Text(text = "Save")
            }
        }

        Text(
            text = loaddata,
            modifier = Modifier.align(alignment = Alignment.Center),
            fontSize = 35.sp
        )
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),

        ) {
            OutlinedTextField(
                value = textfield3,
                onValueChange ={
                    textfield3=it
                },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Enter key")}

            )
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        GlobalScope.launch {
                         dataStoreManager.load(textfield3).collect{
                             loaddata=it
                         }
                        }
                    },
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .height(55.dp)
                ) {
                    Text(text = "Load")
                }
            }

        }


    }
}




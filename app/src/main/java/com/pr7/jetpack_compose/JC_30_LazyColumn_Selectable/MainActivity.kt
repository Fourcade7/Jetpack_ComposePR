package com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable.ui.theme.CardBackground
import com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable.ui.theme.DarkerGreen
import com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.Shapes
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val mainViewModel:MainViewModel by viewModels()
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("PR77777", "onCreate: ${8}")

            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val mylist by remember {
                        mutableStateOf(listOf<String>())
                    }
                    val array= arrayOf(
                        Laptop(name = "item 1"),
                        Laptop(name = "item 2"),
                        Laptop(name = "item 3"),
                        Laptop(name = "item 4"),
                        Laptop(name = "item 5"),
                        Laptop(name = "item 6"),
                        Laptop(name = "item 7"),
                    )
                    var selectedarraylist by remember {
                        mutableStateOf(ArrayList<Laptop>())
                    }
                    multiselectionLazyColumn(array = array, mainViewModel = mainViewModel,selectedarraylist)

                    mainViewModel.mutableLiveData.observe(this@MainActivity,{
                        Log.d("PR77777", "livedata: ${it.size}")
                        selectedarraylist=ArrayList<Laptop>()
                        selectedarraylist=it

                    })

                    GlobalScope.launch {
                        mainViewModel.mutablestateflow.collect{
                            Log.d("PR77777", "stateflow: ${it.size}")

                        }
                    }



                }
            }
        }
    }
}



//@Preview
@Composable
fun multiselectionLazyColumn(array: Array<Laptop>,mainViewModel: MainViewModel,selectedarraylist:ArrayList<Laptop>){
    Column() {
        Text(buildAnnotatedString {
        selectedarraylist.forEach {
            append("${it.name} ")

        }
        })
        LazyColumn(){
            itemsIndexed(items =array ){index: Int, item: Laptop ->
                lazyselectitem(item = item,mainViewModel)
            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun lazyselectitem(item:Laptop,mainViewModel: MainViewModel) {
    var selecteditem by remember {
        mutableStateOf(item.selected)
    }


    Column(modifier = Modifier.padding(5.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    selecteditem = !selecteditem
                    if (selecteditem) {
                        mainViewModel.additem(laptop = item)
                        mainViewModel.insertitem(laptop = item)
                        //mainViewModel.mutableLiveData?.postValue(mainViewModel.mutableLiveData?.value)
                    } else {
                        mainViewModel.deleteitem(laptop = item)
                        mainViewModel.removeitem(laptop = item)
                        //mainViewModel.mutableLiveData?.postValue(mainViewModel.mutableLiveData?.value)

                    }
                },
            //shape = Shapes.medium,
            shape = RoundedCornerShape(size = 8.dp),
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Box(modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()

            ) {
                Text(text = item.name)
                if (selecteditem){
                    Icon(
                        imageVector = Icons.Rounded.Done,
                        contentDescription = "Done",
                        tint = DarkerGreen,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }


            }
        }
    }


}





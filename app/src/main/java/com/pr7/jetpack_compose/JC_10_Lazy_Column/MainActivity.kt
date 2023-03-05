package com.pr7.jetpack_compose.JC_10_Lazy_Column

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_10_Lazy_Column.repository.PersonRepository
import com.pr7.jetpack_compose.JC_10_Lazy_Column.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_10_Lazy_Column.view.prcustomitem

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
                    prlazycolumn()
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prlazycolumn() {
    val personRepository=PersonRepository()
    LazyColumn(
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ){
        items(personRepository.getallData()){
            prcustomitem(person = it)
        }
        items(3){
            Text(text = "Axaxa")
        }
        itemsIndexed(personRepository.getallData()){index, item ->
            prcustomitem(person = item)
        }
    }


}
@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class
)

package com.pr7.jetpack_compose.JC_25_LazyGrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pr7.jetpack_compose.JC_25_LazyGrid.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.Shapes
import com.pr7.jetpack_compose.R

class MainActivity : ComponentActivity() {
    val arraylistimages=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arraylistimages.add(R.drawable.adobe)
        arraylistimages.add(R.drawable.youtube)
        arraylistimages.add(R.drawable.yandex)
        arraylistimages.add(R.drawable.firebase)
        arraylistimages.add(R.drawable.swift)
        arraylistimages.add(R.drawable.google)
        arraylistimages.add(R.drawable.img)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //prlazygrid(imagearraylist = arraylistimages)
                    prlazygridstaggered(imagearraylist = arraylistimages)
                }
            }
        }
    }
}




@Composable
fun prlazygrid(imagearraylist:ArrayList<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
        //columns = GridCells.Adaptive(minSize = 108.dp)
    ) {
//        items(10,key = null){
//           lazyitem()
//        }
        items(imagearraylist) { photo ->
            lazyitem(photo)
        }

    }
}

@Composable
fun prlazygridstaggered(imagearraylist:ArrayList<Int>) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.fillMaxSize()
    ){
        itemsIndexed(imagearraylist,key = null){index: Int, item: Int ->
            lazyitem(image = item)
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun lazyitem(image:Int) {
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .wrapContentHeight(),
            shape = Shapes.medium
        ) {
               Column(modifier = Modifier.fillMaxSize()) {
                   Image(
                       painter = painterResource(id = image),
                       contentDescription = "",
                       contentScale = ContentScale.Crop,
                       modifier = Modifier
                           .fillMaxWidth()
                           .height(((50 until 400).random()).dp)
                   )
                   Text(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(10.dp),
                       text = "Pr",
                       textAlign = TextAlign.Center
                   )
               }

        }
    }

}
/*
* LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    items(photos) { item ->
        PhotoItem(item)
    }
}*/

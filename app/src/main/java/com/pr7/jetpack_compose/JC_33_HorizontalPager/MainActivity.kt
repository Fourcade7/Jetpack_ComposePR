@file:OptIn(
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jetpack_compose.JC_33_HorizontalPager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_2_Box_and_Align.ui.theme.Shapes
import com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable.ui.theme.CardBackground
import com.pr7.jetpack_compose.JC_31_LazyRow.ui.theme.CardviewBackground
import com.pr7.jetpack_compose.JC_33_HorizontalPager.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R
import kotlinx.coroutines.launch

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
                    //horizontalpager()

                    val images = arrayOf(
                        R.drawable.adobe,
                        R.drawable.firebase,
                        R.drawable.img,
                        R.drawable.google,
                        R.drawable.swift,
                        R.drawable.yandex,
                        R.drawable.youtube,

                        )
                    horizontalimageslider(images)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun horizontalpager() {
    val pagerState = rememberPagerState { 10 }

    HorizontalPager(
        modifier = Modifier,
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.Blue)
                .fillMaxWidth()
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = page.toString(), fontSize = 32.sp)
        }
    }
}


@Composable
fun horizontalimageslider(array: Array<Int>) {
    val pagerState = rememberPagerState { array.size }
    val scope = rememberCoroutineScope()
    Box() {
        HorizontalPager(
            modifier = Modifier,
            state = pagerState
        ) { page ->
            Image(
                painter = painterResource(id = array.get(page)),
                contentDescription = "google",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp),
                contentScale = ContentScale.Crop
            )
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .background(CardBackground)
                .padding(bottom = 1.dp),
            shape = RoundedCornerShape(100)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {

                IconButton(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage-1
                            )
                        }

                    },

                    ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
                IconButton(
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                pagerState.currentPage+1
                            )
                        }
                    },

                    ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Go")
                }

            }
        }

    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewmageslider() {
    horizontalimageslider(array = emptyArray())
}


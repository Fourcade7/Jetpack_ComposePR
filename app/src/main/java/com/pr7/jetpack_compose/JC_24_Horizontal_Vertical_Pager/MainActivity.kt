

package com.pr7.jetpack_compose.JC_24_Horizontal_Vertical_Pager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_24_Horizontal_Vertical_Pager.ui.theme.Jetpack_ComposeTheme

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

                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prpager() {

    // You can use PagerState to define an initial page
//    val state = rememberPagerState(initialPage = 5) { 10 }
//    HorizontalPager(
//        modifier = Modifier.fillMaxSize(),
//        state = state,
//
//    ) { page ->
//        Box(
//            modifier = Modifier
//                .padding(10.dp)
//                .background(Color.Blue)
//                .fillMaxWidth()
//                .aspectRatio(1f),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(text = page.toString(), fontSize = 32.sp)
//        }
//    }


}

//@ExperimentalFoundationApi
//@Composable
//fun rememberPagerState(
//    initialPage: Int = 0,
//    initialPageOffsetFraction: Float = 0.0f,
//    pageCount: () -> Int
//): PagerState
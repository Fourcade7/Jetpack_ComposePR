@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jetpack_compose.JC_35_Onboarding_Screen_With_HorizontalPager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_35_Onboarding_Screen_With_HorizontalPager.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
                    val images = arrayOf(
                        R.drawable.adobe,
                        R.drawable.firebase,
                        R.drawable.img,
                        R.drawable.google,
                        R.drawable.swift,
                        R.drawable.yandex,
                        R.drawable.youtube,

                        )
                    val desc= arrayOf(
                        "Welcome",
                        "to",
                        "My",
                        "App",
                    )
                    onboardingscreen(images,desc)
                }
            }
        }
    }
}




@Composable
fun onboardingscreen(array: Array<Int>,arraydesc: Array<String>) {
    val pagerState = rememberPagerState { array.size }
    val scope= rememberCoroutineScope()
    Column() {
        HorizontalPager(
            state = pagerState
        ) {
            onboarditem(page = it, pagerState = pagerState, array = array,arraydesc)
        }

        Button(onClick = {
            scope.launch { 
                pagerState.animateScrollToPage(
                    pagerState.currentPage+1
                )
            }
            pagerState.currentPage
        }) {
            
            Text(text = "Go")

        }
        Text(
            text = if (pagerState.currentPage<arraydesc.size) arraydesc[pagerState.currentPage] else "WELCOME",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 15.dp),
            fontSize = 30.sp)
    }
}


@Composable
fun onboarditem(page:Int,pagerState: PagerState,array: Array<Int>,arraydesc: Array<String>) {
    Column() {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(15.dp),
            colors = CardDefaults.cardColors(Color.LightGray)

        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Image(painter = painterResource(id = array[page]), contentDescription = "google")
                Text(
                    text = "$page",
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(top = 15.dp),
                    fontSize = 30.sp)
            }

        }


    }
}
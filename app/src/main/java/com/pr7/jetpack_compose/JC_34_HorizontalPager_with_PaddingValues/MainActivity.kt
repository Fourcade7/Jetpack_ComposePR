@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jetpack_compose.JC_34_HorizontalPager_with_PaddingValues

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_30_LazyColumn_Selectable.ui.theme.CardBackground
import com.pr7.jetpack_compose.JC_34_HorizontalPager_with_PaddingValues.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.R

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
                    horizontalpagerforgraphicslayer2()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun horizontalpagerforgraphicslayer2() {

    var animate by remember {
        mutableStateOf(0.8f)
    }
    val animatefloatt by animateFloatAsState(
        targetValue = animate,
        animationSpec = tween(2000,
                easing = LinearOutSlowInEasing)
    )
    val images = arrayOf(
        R.drawable.adobe,
        R.drawable.firebase,
        R.drawable.img,
        R.drawable.google,
        R.drawable.swift,
        R.drawable.yandex,
        R.drawable.youtube,

        )
    val pagerState = rememberPagerState { images.size }
    Column(

    ) {


        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 100.dp),

        ) { page ->
            pageritem(pagenumber = page, pagerState = pagerState,images)

        }

    }


}



//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun pageritem(pagenumber:Int,pagerState: PagerState,array: Array<Int>) {

    var animvalue by remember {
        mutableStateOf(true)
    }
    val animationfloat by animateFloatAsState(
        targetValue = if (animvalue) 1f else 0.85f,
        animationSpec = tween(500)
    )
    val animateint by animateIntAsState(
        targetValue = if (animvalue) 50 else 15,
        animationSpec = tween(1000)
    )
    val animationfloatrotation by animateFloatAsState(
        targetValue = if (animvalue) 360f else 0f,
        animationSpec = tween(500)
    )

    animvalue=if (pagerState.currentPage == pagenumber) true else false

    Card(
        modifier = Modifier

            .graphicsLayer {
                scaleY = animationfloat
            }
            .wrapContentHeight()
            .padding(5.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),

    ) {
        Column(
            modifier = Modifier.background(CardBackground)
        ) {
            Image(
                painter = painterResource(id =array.get(pagenumber)),
                contentDescription = "adobe",
                modifier = Modifier
                    .size(200.dp)
                    .padding(animateint.dp)
                    .clip(RoundedCornerShape(animateint))
                    .rotate(animationfloatrotation),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = "$pagenumber", 
                fontSize = if (pagerState.currentPage==pagenumber) animateint.sp else animateint.sp,
                modifier = Modifier
                    .fillMaxWidth().padding(bottom = 15.dp),
                textAlign = TextAlign.Center
            )

        }



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun horizontalpagerforgraphicslayer() {
    val pagerState = rememberPagerState { 10 }
    var animate by remember {
        mutableStateOf(0.8f)
    }
    val animatefloatt by animateFloatAsState(
        targetValue = animate,
        animationSpec = tween(2000,
            easing = LinearOutSlowInEasing)
    )
    Column(

    ) {
        val horizontalPadding = 86.dp
        var itemWidth = 340.dp
        val screenWidth = LocalConfiguration.current.screenWidthDp
        val contentPadding = PaddingValues(start = horizontalPadding, end = horizontalPadding)
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 100.dp),


            ) { page ->
            if (pagerState.currentPage == 2) {
                animate = 1f
            } else {
                animate = 0.8f
            }
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { page ->
                    // do your stuff with selected page
                }
            }
            Box(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .graphicsLayer {

                        alpha = animatefloatt
//                        scaleX=animatefloatt
                        scaleY = animatefloatt

                    }
                    .padding(10.dp)
                    .background(Color.Blue)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "page :${page}\n\nfloat${animatefloatt}\n\ncurrentpage ${pagerState.currentPage}", fontSize = 52.sp)


            }
        }

    }


}


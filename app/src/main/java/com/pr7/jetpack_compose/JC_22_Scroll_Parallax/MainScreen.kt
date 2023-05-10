package com.pr7.jetpack_compose.JC_22_Scroll_Parallax

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.R


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prParallax() {

    val scrollState= rememberScrollState()
    var value by remember {
        mutableStateOf(0f)
    }
    val animationfloat by animateFloatAsState(
        targetValue =value,
        animationSpec = tween(1000)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
    ) {
        Image(
            painter = painterResource(id = R.drawable.adobe), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .graphicsLayer {
                    value = 1f - (scrollState.value.toFloat() / scrollState.maxValue)
                    translationY = ((scrollState.value) / 2).toFloat()//2x slow scroll
                }
                .alpha(animationfloat)
                .rotate(animationfloat*10),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(10.dp),
            text ="${animationfloat}"+ " Adobe Premiere Pro Adobe After Effects".repeat(30)+" ${animationfloat}",
            fontSize = 20.sp
        )
    }

}
@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package com.pr7.jetpack_compose.JC_37_Tab_Custom_UI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.ui.theme.AdobeCustomColor
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.ui.theme.Shapes
import com.pr7.jetpack_compose.JC_12_Navigation_Send_Arguments.ui.theme.YandexCustomColor
import com.pr7.jetpack_compose.JC_37_Tab_Custom_UI.ui.theme.Jetpack_ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            customtabui()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun customtabui() {
    val tabItems = listOf(
        TabModel("Image", Icons.Default.Add),
        TabModel("Music", Icons.Default.Email),
        TabModel("Video", Icons.Default.Search),
    )

    val pagerState = rememberPagerState{tabItems.size}
    val scope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions: List<TabPosition> ->
                Box() {}
            }

            ) {
            tabItems.forEachIndexed { index, item ->
                tabitem(
                    onclick = { scope.launch { pagerState.animateScrollToPage(index) } },
                    selected = pagerState.currentPage == index,
                    title = item.title,
                    icon = item.icon,
                )
            }
        }
        HorizontalPager(state = pagerState) {
            when(pagerState.currentPage){
                0 -> { ImageTab() }
                1 -> { MusicTab() }
                2 -> { SearchTab() }
            }
        }
    }
}

@Composable
fun tabitem(
    onclick:()->Unit,
    selected: Boolean,
    title: String,
    icon: ImageVector? = null,
) {

    val selectedColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground

    Tab(
        selected = selected,
        onClick = onclick,
        modifier = Modifier.background(Color.LightGray)
    ) {
        Column(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(50.dp))
                .background(if (selected) YandexCustomColor else Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            if (icon != null) Icon(icon, contentDescription = title, tint = selectedColor)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = title,
                color = selectedColor
            )


            if (selected){
                Box(
                    contentAlignment = Alignment.BottomCenter,

                ) {
                    Surface(
                        shape = RoundedCornerShape(50.dp),
                        color = AdobeCustomColor,
                        modifier = Modifier.height(5.dp).width(40.dp)

                    ) {

                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
    }

}


data class TabModel constructor(
    val title:String,
    val icon: ImageVector?=null
)

//Screens
@Composable
fun ImageTab() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Image", fontSize = 32.sp)
    }
}
@Composable
fun MusicTab() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Music", fontSize = 32.sp)
    }
}
@Composable
fun SearchTab() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Search", fontSize = 32.sp)
    }
}


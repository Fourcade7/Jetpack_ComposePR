@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package com.pr7.jetpack_compose.JC_36_Tab_Ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_36_Tab_Ui.ui.theme.Jetpack_ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            tabui()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun tabui() {
    val tabItems = listOf(
        TabModel("Image", Icons.Default.Add),
        TabModel("Music", Icons.Default.Email),
        TabModel("Video", Icons.Default.Search),
    )

    val pagerState = rememberPagerState{tabItems.size}
    val scope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
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
    val tabHeight = if (icon != null) 54.dp else 38.dp
    val bottomPadding = if (icon != null) 5.dp else 5.dp
    val selectedColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground

    Tab(selected = selected, onClick = onclick) {
        Column(
            Modifier
                .padding(top = 10.dp, bottom = bottomPadding)
                .height(tabHeight)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (icon != null) Icon(icon, contentDescription = title, tint = selectedColor)
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = title,
                color = selectedColor
            )
        }
    }
    
}


data class TabModel constructor(
    val title:String,
    val icon:ImageVector?=null
)


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





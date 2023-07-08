@file:OptIn(ExperimentalMaterialApi::class)

package com.pr7.jetpack_compose.JC_39_Bottom_sheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_39_Bottom_sheet.ui.theme.Jetpack_ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            bottomsheetmain()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun bottomsheetmain() {

    var showbottomSheet by rememberSaveable {
        mutableStateOf(false)
    }

    var showmodalbottomsheet by rememberSaveable {
       mutableStateOf(false)
    }

    if (showbottomSheet){
        bottomsheetscaffold()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            showbottomSheet = !showbottomSheet
        }) {
            Text(text = "Show/Hide BottomSheetScaffold")
        }
        Button(onClick = {
            showmodalbottomsheet = !showmodalbottomsheet
        }) {
            Text(text = "Show/Hide ModalBottomSheet")
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun bottomsheetscaffold() {
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState=scaffoldState,
        sheetPeekHeight = 140.dp,
        backgroundColor = Color.LightGray,
        sheetBackgroundColor = Color.DarkGray,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Row(
                modifier = Modifier.padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start)
            ) {
                Icon(Icons.Default.Share, contentDescription = "Share")
                Text(text = "Share")
            }

            Button(onClick = { scope.launch { scaffoldState.bottomSheetState.isCollapsed } }) {
                Text(text = "Expand BottomSheet")
            }
            Button(onClick = { scope.launch { scaffoldState.bottomSheetState.isCollapsed } }) {
                Text(text = "PartialExpand BottomSheet")
            }
        }) {}


}







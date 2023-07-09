@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class, ExperimentalMaterialApi::class
)

package com.pr7.jetpack_compose.JC_40_Bottom_sheet_Scaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pr7.jetpack_compose.JC_40_Bottom_sheet_Scaffold.ui.theme.Jetpack_ComposeTheme

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
                bottomsheetscaffold()
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun bottomsheetscaffold() {

    BottomSheetScaffold(
        sheetContent = {
            Text(text = "Go UP")
            Text(text = "Go UP")
            Text(text = "Go UP")
            Text(text = "Go UP")
            Text(text = "Go UP")
        },
        sheetPeekHeight = BottomSheetScaffoldDefaults.SheetPeekHeight,
        topBar = {
            TopAppBar() {
                Text(text = "Bottom Sheet")
            }
        },
        scaffoldState = rememberBottomSheetScaffoldState()
    ) {
        Text(text = "Body Content")
    }


}
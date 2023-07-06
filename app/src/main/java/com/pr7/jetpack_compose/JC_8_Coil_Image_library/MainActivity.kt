package com.pr7.jetpack_compose.JC_8_Coil_Image_library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.pr7.jetpack_compose.JC_8_Coil_Image_library.ui.theme.Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                prcoilimagelibrary()
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prcoilimagelibrary() {
    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = com.pr7.jetpack_compose.R.drawable.google),
            model = "https://mgames.ua/upload/catalog_products_photos/images/s_3797_0d8qzijhd5n50xlsji4ezg6d1600529784.jpg",
            contentDescription = null,
            contentScale = ContentScale.Crop

        )

        SubcomposeAsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            model = "https://masterfresok.ru/upload/iblock/070/fotooboi-ulitsy-nochnogo-goroda-foto.jpg",
            loading = {
                CircularProgressIndicator(modifier = Modifier.size(30.dp))
            },
            contentDescription = null,
            contentScale = ContentScale.Crop

        )
    }
}
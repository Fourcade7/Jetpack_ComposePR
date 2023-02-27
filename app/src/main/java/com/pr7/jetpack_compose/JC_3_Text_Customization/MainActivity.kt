package com.pr7.jetpack_compose.JC_3_Text_Customization

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_3_Text_Customization.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.JC_3_Text_Customization.ui.theme.Shapes

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

                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prtextcustomization() {

    Column() {
      for (i in 0 until 3){
          if (i==1){
              Text(text = "Fouracde")
          }
          Text(
              modifier = Modifier
                  .padding(10.dp)
                  .background(Color.LightGray)
                  .padding(10.dp)
                  .wrapContentSize(),
              text = "Fourcade7",
              fontSize = 25.sp,
              fontStyle = FontStyle.Normal,
              fontWeight = FontWeight.Bold

          )
      }
    }


}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prcustomstrings() {
    Column {
        Text(buildAnnotatedString {
            withStyle(SpanStyle(fontSize = 35.sp)){
                append("A")
            }
            append("B")
            append("C")
            append("D")

        })



        Text(text = "Fourcade ".repeat(20), maxLines = 2, overflow = TextOverflow.Clip)

    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prtextselection() {
    Column {
        SelectionContainer {
            Column() {
                Text(text = "Xaxaxa")
                DisableSelection {
                    Text(text = "Dont Select")
                }
                Text(text = "Uaxaxaxa")
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun prtextsubscriptandsuperscript() {
        Text(buildAnnotatedString {
            withStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)){
                append("фоуркаде")
            }
            withStyle(SpanStyle(baselineShift = BaselineShift.Subscript)){
                append("a")
            }
            withStyle(SpanStyle(baselineShift = BaselineShift.Superscript)){
                append("b")
            }
            append("777")

        })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun prcustomtextwithsurface() {
   Column(
       modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
    Surface(
        modifier = Modifier.size(150.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Click me")
        }

    }
   }

}

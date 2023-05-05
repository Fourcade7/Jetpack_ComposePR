package com.pr7.jetpack_compose.JC_19_LazyColumn_Clicakble_New_Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pr7.jetpack_compose.JC_19_LazyColumn_Clicakble_New_Activity.ui.theme.Jetpack_ComposeTheme
import com.pr7.jetpack_compose.ui.theme.Shapes
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
                    val userlist by remember {
                        mutableStateOf(ArrayList<User>())
                    }
                    userlist.add(User(R.drawable.google, "Google"))
                    userlist.add(User(R.drawable.img, "Desktop Image"))
                    userlist.add(User(R.drawable.yandex, "Yandex"))
                    userlist.add(User(R.drawable.firebase, "Firebase"))
                    userlist.add(User(R.drawable.swift, "Swift"))
                    userlist.add(User(R.drawable.youtube, "YouTube"))
                    userlist.add(User(R.drawable.adobe, "Adobe CC"))

                    golazycolumn(arrayList = userlist)


                }
            }
        }
    }
}

@Composable
fun golazycolumn(arrayList: ArrayList<User>) {
    LazyColumn() {
        itemsIndexed(arrayList) { index: Int, item: User ->
            lazyitem(user = item)
        }
    }

}


@Composable
fun lazyitem(user: User) {
    val context = LocalContext.current
    Column() {
        Column(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .wrapContentHeight()
            //.background(Color.Black),


        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = Shapes.medium,
                        clip = false,
                        ambientColor = Color.Blue,
                        spotColor = Color.Cyan
                    )
                    .clickable {
                        val intent = Intent(context, MainActivity2::class.java)
                       intent.apply {
                           putExtra("image",user.image)
                           putExtra("name",user.name)
                       }
                        context.startActivity(intent)
                    },
                shape = Shapes.medium,

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(id = user.image), contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(50.dp)
                            .align(alignment = CenterVertically),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = user.name,
                        modifier = Modifier.align(CenterVertically),
                        fontSize = 17.sp,
                        fontStyle = FontStyle.Normal,
                        //fontWeight = FontWeight.Bold

                    )
                }
            }
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun defaultpreview() {
    val user = User(R.drawable.google, "Google")
    lazyitem(user = user)
}
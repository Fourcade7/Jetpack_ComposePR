package com.pr7.jetpack_compose.JC_27_Retrofit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun PostUiLazyColumn(arrayList: ArrayList<PostModel>) {
    LazyColumn(){
        itemsIndexed(arrayList){index,item->
            PostResponseUi(postModel = item)
        }
    }
    
}

@Composable
fun PostResponseUi(postModel: PostModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp),

    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            text = postModel.body,
            fontSize = 35.sp

        )
    }
}
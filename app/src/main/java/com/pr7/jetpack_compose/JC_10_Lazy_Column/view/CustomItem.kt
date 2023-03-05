package com.pr7.jetpack_compose.JC_10_Lazy_Column.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pr7.jetpack_compose.JC_10_Lazy_Column.model.Person
import com.pr7.jetpack_compose.JC_7_Expandable_Cardview.ui.theme.Shapes


@Composable
fun prcustomitem(person: Person) {
    Surface(
        modifier = Modifier
            .padding(0.dp) //margin
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(1.dp),
        shape = Shapes.medium,
        color = Color.LightGray
    ) {
        Row(
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = person.id.toString())
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = person.name)
        }
    }
}

@Preview(showBackground = true, showSystemUi =true)
@Composable
fun previewcustomitem() {
    prcustomitem(person = Person(id = 0, name = "Pr"))
}
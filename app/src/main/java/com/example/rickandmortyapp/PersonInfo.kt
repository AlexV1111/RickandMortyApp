package com.example.rickandmortyapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PersonInfo() {

    val person = Person(
        0,
        "Rick Sanchez",
        "Alive",
        "Human",
        "",
        "Male",
        R.drawable.rick,
        emptyList(),
        "",
        "",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(person.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Text("Name:  ${person.name}")
        Text("Status: ${person.status}")
        Text("Species: ${person.species}")
        Text("Gender: ${person.gender}")
        Text("Type: ${person.type}")
    }
}
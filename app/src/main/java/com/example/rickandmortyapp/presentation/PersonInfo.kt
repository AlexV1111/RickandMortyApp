package com.example.rickandmortyapp.presentation

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
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.domain.entity.Location
import com.example.rickandmortyapp.domain.entity.Origin
import com.example.rickandmortyapp.domain.entity.Person
import kotlin.Int

@Composable
fun PersonInfo() {

    val person = Person(
        id = 0,
        name = "Rick Sanchez",
        status = "Alive",
        species = "Human",
        type = "",
        gender = "Male",
        origin = Origin("", ""),
        location = Location("", ""),
        image = R.drawable.rick,
        episode = emptyList(),
        created = "",
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
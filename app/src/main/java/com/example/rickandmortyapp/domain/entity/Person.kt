package com.example.rickandmortyapp.domain.entity

import com.example.rickandmortyapp.R

data class Person(
    val id: Int = 0,
    val name: String = "Rick Sanchez",
    val status: String = "Alive",
    val species: String = "Human",
    val type: String = "",
    val gender: String = "Male",
    val origin: Origin = Origin("", ""),
    val location: Location = Location("", ""),
    val image: Int = R.drawable.rick,
    val episode: List<String> = emptyList(),
    val created: String = "",
)
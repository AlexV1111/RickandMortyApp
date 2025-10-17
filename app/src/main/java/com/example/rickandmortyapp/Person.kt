package com.example.rickandmortyapp

data class Person(
    val id: Int = 0,
    val name: String = "Rick Sanchez",
    val status: String = "Alive",
    val species: String = "Human",
    val type: String = "",
    val gender: String = "Male",
    val image: Int = R.drawable.rick,
    val episode: List<String> = emptyList(),
    val location: String = "",
    val created: String = "",
)
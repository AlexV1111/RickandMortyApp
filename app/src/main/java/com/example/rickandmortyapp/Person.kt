package com.example.rickandmortyapp

data class Person(
    val id: Int = 1,
    val name: String = "Rick Sanchez",
    val status: String = "Alive",
    val species: String = "Human",
    val gender: String = "Male",
    val image: Int = R.drawable.rick,
)

package com.example.rickandmortyapp.data.dto

data class PersonDTO(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDTO,
    val location: LocationDTO,
    val image: Int,
    val episode: List<String>,
    val created: String
)

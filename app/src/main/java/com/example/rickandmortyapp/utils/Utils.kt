package com.example.rickandmortyapp.utils

import com.example.rickandmortyapp.domain.entity.Person

fun search(text: String, usersList: List<Person>): List<Person> {
    return if (text.isEmpty()) {
        usersList
    } else {
        usersList.filter {
            it.name.lowercase().startsWith(text.lowercase())
        }
    }
}
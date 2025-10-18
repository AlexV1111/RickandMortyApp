package com.example.rickandmortyapp.domain.repository

import com.example.rickandmortyapp.domain.entity.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun getPersonList(): Flow<List<Person>>
    suspend fun getPersonById(personId: Int): Person
}
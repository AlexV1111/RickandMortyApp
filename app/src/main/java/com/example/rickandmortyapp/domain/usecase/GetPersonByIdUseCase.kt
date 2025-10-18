package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.entity.Person
import com.example.rickandmortyapp.domain.repository.PersonRepository

class GetPersonByIdUseCase(val personRepository: PersonRepository) {
    suspend fun getPersonById(personId: Int): Person {
        return personRepository.getPersonById(personId)
    }
}
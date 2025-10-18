package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.domain.entity.Person
import com.example.rickandmortyapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

class GetPersonListUseCase(val personRepository: PersonRepository) {
    suspend fun getPersonList(): Flow<List<Person>> {
        return personRepository.getPersonList()
    }
}
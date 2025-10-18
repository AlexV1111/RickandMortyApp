package com.example.rickandmortyapp.data

import com.example.rickandmortyapp.data.mapper.DtoMapper
import com.example.rickandmortyapp.data.remote.ApiFactory
import com.example.rickandmortyapp.domain.entity.Person
import com.example.rickandmortyapp.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PersonRepositoryImpl() : PersonRepository {

    private val api = ApiFactory.apiService
    private val mapper = DtoMapper()

    override suspend fun getPersonList(page: Int): Flow<List<Person>> = flow {
        try {
            val personListResponse = api.getPersonList(page)
            emit(mapper.mapListDtoToEntity(personListResponse))
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getPersonById(personId: Int): Person {
        val personResult = try {
            val personResponse = api.getPersonById(personId)
            mapper.mapDtoToEntity(personResponse)
        } catch (e: Exception) {
            throw e
        }
        return personResult
    }
}
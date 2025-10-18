package com.example.rickandmortyapp.data.mapper

import com.example.rickandmortyapp.data.dto.LocationDTO
import com.example.rickandmortyapp.data.dto.OriginDTO
import com.example.rickandmortyapp.data.dto.PersonDTO
import com.example.rickandmortyapp.data.dto.PersonListDTO
import com.example.rickandmortyapp.domain.entity.Location
import com.example.rickandmortyapp.domain.entity.Origin
import com.example.rickandmortyapp.domain.entity.Person

class DtoMapper {
    fun mapDtoToEntity(personDTO: PersonDTO): Person {
        return Person(
            personDTO.id,
            personDTO.name,
            personDTO.status,
            personDTO.species,
            personDTO.type,
            personDTO.gender,
            personDTO.origin.mapDtoToEntity(),
            personDTO.location.mapDtoToEntity(),
            personDTO.image,
            personDTO.episode,
            personDTO.created
        )
    }

    fun mapListDtoToEntity(personListDTO: PersonListDTO): List<Person> {
        return personListDTO.results.map { mapDtoToEntity(it) }
    }

    private fun OriginDTO.mapDtoToEntity() = Origin(name, url)
    private fun LocationDTO.mapDtoToEntity() = Location(name, url)
}
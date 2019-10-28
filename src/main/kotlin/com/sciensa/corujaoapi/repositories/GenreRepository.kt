package com.sciensa.corujaoapi.repositories

import com.sciensa.corujaoapi.models.Genre
//import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.CrudRepository

// Gerencia os models para realizar a comunicação com a base de dados
interface GenreRepository: CrudRepository<Genre, String> // <Tipo do dominio, id>
//interface GenreRepository: MongoRepository<Genre, Long>
package com.sciensa.corujaoapi.services

import com.sciensa.corujaoapi.models.Genre
import com.sciensa.corujaoapi.repositories.GenreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GenreService (private val genreRepository: GenreRepository) {

    fun listGenres(): List<Genre> {
        return genreRepository.findAll().toList()
    }

    fun addGenre(genre: Genre): Genre {
        return genreRepository.save(genre)
    }

    fun updateGenre(id: String, genre: Genre): Genre {
        var safeGenre = genre.copy(id = id)
        return addGenre(safeGenre)
    }

    fun getGenre(id: String): Optional<Genre> {
        return genreRepository.findById(id)
    }

    fun existsById(id: String): Boolean {
        return genreRepository.existsById(id)
    }

}
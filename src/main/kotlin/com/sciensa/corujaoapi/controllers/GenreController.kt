package com.sciensa.corujaoapi.controllers

import com.sciensa.corujaoapi.models.Genre
import com.sciensa.corujaoapi.services.GenreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import java.util.*

@RestController
@RequestMapping("/v1/genres")
class GenreController @Autowired constructor (private val genreService: GenreService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listGenres(): ResponseEntity<List<Genre>> {
        val genres = genreService.listGenres()
        return ResponseEntity.status(HttpStatus.OK).body(genres)
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addGenre(@RequestBody genre: Genre): ResponseEntity<Genre> {
        val genre: Genre = genreService.addGenre(genre)
        return ResponseEntity.ok(genre)
    }

    @PutMapping("/{id}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateGenre(@PathVariable id: String, @RequestBody genre: Genre): ResponseEntity<Genre> {
        if (genreService.existsById(id)) {
            val updatedGenre = genreService.updateGenre(id, genre)
            return ResponseEntity.status(HttpStatus.OK).body(updatedGenre)
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
    }

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getGenre(@PathVariable id: String): ResponseEntity<Optional<Genre>> {
        if (id === "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
        }

        val genre = genreService.getGenre(id)
        return ResponseEntity.status(HttpStatus.OK).body(genre)

        /*return try {
            val genre = genreService.getGenre(id)
            ResponseEntity.status(HttpStatus.OK).body(genre)
        }
        catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }*/
    }

}
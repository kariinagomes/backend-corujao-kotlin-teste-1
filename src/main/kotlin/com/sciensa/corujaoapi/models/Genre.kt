package com.sciensa.corujaoapi.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

/*@Document
data class Genre(
        @Id val id: Long,
        val description: String,
        //val createdAt: Instant?,
        val createdAt: Date,
        val updatedAt: Date
)*/

@Document // faz o mapeamento para o mongodb
data class Genre(
        @Id val id: String? = null,
        val description: String? = null,
        val createdAt: Date? = null,
        val updatedAt: Date? = null
)

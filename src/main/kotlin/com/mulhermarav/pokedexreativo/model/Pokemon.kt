package com.mulhermarav.pokedexreativo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Pokemon(
    @Id
    val id: String?,
    val name: String,
    val category: String,
    val abilities: List<String>,
    val weight: Double
)

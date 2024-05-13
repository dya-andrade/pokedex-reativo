package com.mulhermarav.pokedexreativo.repository

import com.mulhermarav.pokedexreativo.model.Pokemon
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PokemonRepository: ReactiveMongoRepository<Pokemon, String>
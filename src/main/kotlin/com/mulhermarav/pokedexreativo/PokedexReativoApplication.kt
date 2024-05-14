package com.mulhermarav.pokedexreativo

import com.mulhermarav.pokedexreativo.model.Pokemon
import com.mulhermarav.pokedexreativo.repository.PokemonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import reactor.kotlin.core.publisher.toFlux

@SpringBootApplication
class PokedexReativoApplication

fun main(args: Array<String>) {
	runApplication<PokedexReativoApplication>(*args)
}

@Configuration
class DataInitializer {

	@Bean
	fun init(operations: ReactiveMongoOperations, repository: PokemonRepository): CommandLineRunner {
		return CommandLineRunner {
			repository.deleteAll().thenMany(
				listOf(
					Pokemon(null, "Bulbassauro", "Semente", listOf("Overgrow", "Chlorophyll"), 6.09),
					Pokemon(null, "Charizard", "Fogo", listOf("Blaze", "Solar Power"), 90.05),
					Pokemon(null, "Caterpie", "Minhoca", listOf("Shield Dust", "Run Away"), 2.09),
					Pokemon(null, "Blastoise", "Marisco", listOf("Torrent", "Rain Dish"), 85.09)
				).toFlux().flatMap { repository.save(it) }
			).thenMany(repository.findAll())
				.subscribe { println(it) }
		}
	}
}

/**
 *  thenMany é usado para encadear operações em um fluxo de eventos.
 *  Ele é para indicar que uma operação deve ser executada após a conclusão de outra operação
 */
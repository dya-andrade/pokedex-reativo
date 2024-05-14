package com.mulhermarav.pokedexreativo.controller

import com.mulhermarav.pokedexreativo.model.Pokemon
import com.mulhermarav.pokedexreativo.model.PokemonEvent
import com.mulhermarav.pokedexreativo.repository.PokemonRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@RestController
@RequestMapping("/pokemons")
class PokemonController(
    private val repository: PokemonRepository,
) {

    @GetMapping
    fun getAllPokemons(): Flux<Pokemon> = repository.findAll()

    @GetMapping("/{id}")
    fun getPokemon(@PathVariable id: String) = repository.findById(id)
        .map { ResponseEntity.ok(it) }
        .defaultIfEmpty(ResponseEntity.notFound().build())

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePokemon(@RequestBody pokemon: Pokemon) = repository.save(pokemon)

    @PutMapping("/{id}")
    fun updatePokemon(@PathVariable id: String, @RequestBody pokemon: Pokemon) =
        repository.findById(id)
            .flatMap {
                repository.save(
                    it.copy(
                        name = pokemon.name,
                        category = pokemon.category,
                        abilities = pokemon.abilities,
                        weight = pokemon.weight
                    )
                )
            }
            .map { ResponseEntity.ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deletePokemon(@PathVariable id: String) = repository.findById(id)
        .flatMap<ResponseEntity<Unit>> {
            repository.delete(it).then(Mono.just(ResponseEntity.ok().build()))
        }
        .defaultIfEmpty(ResponseEntity.notFound().build())

    @DeleteMapping
    fun deleteAllPokemons() = repository.deleteAll()

    @GetMapping("/events", produces = ["text/event-stream"])
    fun getPokemonEvents(): Flux<PokemonEvent> = Flux.interval(Duration.ofSeconds(5))
        .map { PokemonEvent(it, "Pokemon Event") }

    /**
     * then é usado para indicar que uma determinada operação deve ser executada
     * após a conclusão de uma operação anterior em um fluxo reativo.
     * Ele retorna um novo Mono ou Flux que representa a conclusão da operação encadeada.
     */
}
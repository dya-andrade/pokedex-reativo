# pokedex-reativo
Projeto API Rest de Pokedéx Pokemon com Webflux, MongoDB e AWS

### Pré-requisitos

* JDK 8+
* Kotlinc 1.9+
* Gradle 8.7+

### Dependências

* Spring Reactive Web
* Spring Data Reactive MongoDB
* Embedded MongoDB Database

### Build e Execução

```shell
gradle build
```

```shell
gradle bootRun
```

### Exemplo de payload

```json
{
    "name": "Pikachu",
    "category": "Mouse",
    "skills": [
        "Electricity",
        "Speed"
    ],
    "weight": 6.0
}
```

### Endpoints

* GET /pokemons
* GET /pokemons/{id}
* POST /pokemons
* PUT /pokemons/{id}
* DELETE /pokemons/{id}
* GET /pokemons/events

### Por que usar o Webflux?

<p>Em sistemas reativos, os componentes são projetados para reagir a eventos e notificações de forma eficiente, 
pois lidam com fluxos de dados assíncronos, sem bloquear a thread de execução. 
Isso permite que o sistema seja escalável e responsivo.</p>

<p>Aplicativos que requerem atualizações em tempo real, como aplicativos de chat ou sistemas de monitoramento em 
tempo real, o Kotlin com WebFlux pode ser uma escolha poderosa devido à sua natureza reativa.</p>


### Referência

[Ana Beatriz - Dev.to](https://dev.to/womakerscode/criando-seu-pokedex-com-spring-webflux-mongodb-deploy-no-heroku-21f5)

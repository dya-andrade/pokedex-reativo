# pokedex-reativo
Projeto API Rest de Pokedéx Pokemon com Webflux, MongoDB e AWS

### Pré-requisitos

* JDK 17+
* Kotlinc
* Gradle

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

### Deploy no EC2 AWS

* Criar uma instância EC2 na AWS (Ubuntu)

* Se conectar via SSH

```shell
chmod 400 <key.pem>
ssh -i <key.pem> ubuntu@<ip-public>
```
* Instalar o Git e clonar o projeto

```shell
sudo apt-get update
sudo apt-get -y install git
git --version
git clone https://github.com/dya-andrade/pokedex-reativo.git
```

* Instalar o Java 17

```shell
sudo apt-get -y install openjdk-17-jdk
java -version
```

* Instalar o Kotlinc

```shell
sudo apt-get install -y kotlin
kotlinc -version
```

* Instalar o Gradle

```shell
sudo apt-get -y install gradle
gradle --version
```

* Buildar e executar o projeto
    
```shell
cd pokedex-reativo
gradle build
```

### Referência

[Ana Beatriz - Dev.to](https://dev.to/womakerscode/criando-seu-pokedex-com-spring-webflux-mongodb-deploy-no-heroku-21f5)

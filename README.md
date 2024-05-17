# pokedex-reativo
Projeto API Rest de Pokédex Pokémon com Webflux, MongoDB e AWS

### Pré-requisitos

* JDK 17+
* Kotlinc 1.9+
* Gradle 8+

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
#sudo apt-get install -y kotlin
sudo snap install --classic kotlin
kotlinc -version
```

* Instalar o Gradle

```shell
#sudo apt-get -y install gradle
sudo snap install --classic kotlin
gradle --version
```

* Buildar e executar o projeto
    
```shell
cd pokedex-reativo
gradle build
gradle bootRun
```
* Em instâncias EC2 Linux

```shell
sudo dnf update -y
sudo dnf install -y git
git --version
git clone https://github.com/dya-andrade/pokedex-reativo.git

curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

sdk install java 17-open
java -version

sdk install kotlin 1.9.0
kotlinc -version

sdk install gradle 8.7
gradle --version

cd pokedex-reativo
gradle build
gradle bootRun
```

* Acessar a aplicação via HTTP

````
http://<ip-public>:8080/pokemons
````

### Referência

[Ana Beatriz - Dev.to](https://dev.to/womakerscode/criando-seu-pokedex-com-spring-webflux-mongodb-deploy-no-heroku-21f5)

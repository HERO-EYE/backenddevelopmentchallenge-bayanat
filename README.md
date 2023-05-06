# Network Towers REST API - Bayanat

This project is a backend REST API to fetch network towers data. It is written by Java [Spring Boot](https://spring.io/projects/spring-boot).

## Description

The application is a simple REST API that allows the user to fetch network towers data with optional parameters like network operator and technology.

## Getting Started

To get started with this project, you'll need to have [Java 11](https://www.oracle.com/java/technologies/downloads/) installed on your machine.

Clone the repository and navigate to the project directory:

```
git clone https://github.com/HERO-EYE/backenddevelopmentchallenge-bayanat.git
cd your-project
```

Then, run the application using Maven:

```
./mvnw spring-boot:run
```

The application will be running on `http://localhost:8080`.

## Endpoints

The following endpoints are available:

- `GET /challenge/towers`: Returns a list of all network towers.
- `GET /challenge/towers?{tower_id=value?networkoperator=value&technology=value&tower_type=value}`: Returns a list of network towers with optional parameters (tower_id=>Tower ID, networkoperator=>The Operator name, technology=> Network Technology e.g. 4G, tower_type=> The type of tower).


## Technologies Used

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

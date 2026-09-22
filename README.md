# City Explorer API

A simple Spring Boot REST API for exploring, searching, and managing a list of cities.
Built as homework practicing REST controllers, HTTP methods, path variables, query
parameters, and JSON responses.

## Theme

🌍 **City Explorer** — a small catalog of cities with endpoints to browse, search, filter,
add, update, delete, and get statistics.

## Author

Name: Yahya

## Running the app

```bash
mvn spring-boot:run
```

The app runs on **http://localhost:8080** by default.

## Endpoints

| # | Method | Endpoint | Description |
|---|--------|----------|-------------|
| 1 | GET | `/cities/` | Welcome message |
| 2 | GET | `/cities/getcities` | Get all cities |
| 3 | GET | `/cities/getcities/{id}` | Get one city by ID |
| 4 | GET | `/cities/search?name=` | Search cities by name (contains match) |
| 5 | GET | `/cities/filter?letter=` | Filter cities by first letter |
| 6 | GET | `/cities/addcity?name=` | Add a new city |
| 7 | GET | `/cities/updatecity/{id}?name=` | Update a city's name |
| 8 | GET | `/cities/deletecity/{id}` | Delete a city |
| 9 | GET | `/cities/stats` | Total city count |
| 10 | GET | `/cities/supriseme` | Random city recommendation |

## URL examples

1. `http://localhost:8080/cities/`
2. `http://localhost:8080/cities/getcities`
3. `http://localhost:8080/cities/getcities/1`
4. `http://localhost:8080/cities/search?name=lon`
5. `http://localhost:8080/cities/filter?letter=D`
6. `http://localhost:8080/cities/addcity?name=Prague`
7. `http://localhost:8080/cities/updatecity/1?name=Manchester`
8. `http://localhost:8080/cities/deletecity/8`
9. `http://localhost:8080/cities/stats`
10. `http://localhost:8080/cities/supriseme`

## Sample data

The app seeds 7 cities on startup: London, Dubai, Manama, Doha, Frankfurt, Moscow, and California.

## Tech stack

- Java
- Spring Boot
- Maven
- In-memory `HashMap<Integer, String>` (no database)

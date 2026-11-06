# Game Backlog

Games API built with Java 21, Spring Boot and MySQL.

## Running locally

You need a full JDK compatible with Java 21 and a running MySQL instance. Create the `game_backlog` database and a user with access to it.

In the `backend` folder, copy the example configuration and fill in your MySQL credentials:

```bash
cd backend
cp -n .env.example .env
```

The `.env` file is local and is not tracked by Git. If it already exists, keep your settings. Spring Boot does not read this file automatically; load the variables in your terminal before running:

```bash
set -a
source .env
set +a

bash mvnw clean test
bash mvnw spring-boot:run
```

Open the documentation at http://localhost:8080/swagger-ui.html.

## Routes

| Method | Route | Operation |
| --- | --- | --- |
| POST | `/games` | Create a game |
| GET | `/games` | List games |
| GET | `/games/{id}` | Get a game |
| PUT | `/games/{id}` | Update a game |
| DELETE | `/games/{id}` | Delete a game |

Example request body for create and update:

```json
{
  "name": "Elden Ring",
  "description": "Open-world action RPG",
  "value": 199.90,
  "quantity": 1
}
```

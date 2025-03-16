# Java 21 Spring Boot Application with Redis and PostgreSQL

This project is a Spring Boot application running with Java 21. It integrates PostgreSQL for data persistence and Redis for caching, all configured to run via Docker.

## 🚀 Prerequisites

- Java 21
- Maven
- Docker & Docker Compose

## 📂 Project Structure

- **`Dockerfile`**: Defines the build instructions for the Spring Boot application.
- **`docker-compose.yml`**: Configures the services: application, PostgreSQL, and Redis.
- **`application.yml`**: Contains Spring Boot configuration properties.
- **`src/`**: Source code directory.

## ⚙️ Configuration

The `application.yml` is configured as follows:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://postgres:5432/myfaztdb
    username: fazt
    password: 123
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

  cache:
    type: redis

  redis:
    host: redis
    port: 6379
```

## 🐳 Docker Setup

### Build and Start Containers

```bash
docker-compose up --build
```

### Stopping Containers

```bash
docker-compose down
```

### Access PostgreSQL

```bash
docker exec -it postgres psql -U fazt -d myfaztdb
```

### Access Redis

```bash
docker exec -it redis redis-cli
```

## 🧪 Running Tests

Execute unit tests with:

```bash
mvn test
```

## 📄 API Documentation

Swagger is implemented for API documentation. Once the application is running, access it at:

```
http://localhost:8080/swagger-ui.html
```

## ✅ Key Features

- **Caching**: Uses Redis for caching percentage values with `@Cacheable`.
- **Persistence**: PostgreSQL is used for data storage.
- **Error Handling**: If the external percentage service fails, the application retrieves the value from Redis cache.
- **Dockerized**: Full setup using Docker and Docker Compose.

## 🛠️ Troubleshooting

- Ensure ports `8080`, `5432`, and `6379` are free before running the services.
- Use `docker logs <container_name>` to check logs.
- To clear Redis cache during development:

```bash
docker exec -it redis redis-cli flushall
```

## 📚 License

This project is licensed under the MIT License.

---

Happy coding! 🚀


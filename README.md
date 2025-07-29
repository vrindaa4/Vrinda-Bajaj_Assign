# Bajaj Spring Boot Project

A Spring Boot application that implements a webhook service with SQL query execution.

## Features

- REST API with health check endpoint
- Webhook integration with external service
- SQL query execution and processing
- JSON data handling

## Prerequisites

- Java 22+
- Maven 3.6+

## How to Run

### Option 1: Run the JAR file
```bash
java -jar target/bajaj-1.0.0.jar
```

### Option 2: Build from source
```bash
mvn clean package
java -jar target/bajaj-1.0.0.jar
```

## API Endpoints

- `GET /health` - Health check
- `POST /execute` - Execute webhook flow

## Testing

Test the application:
```bash
curl http://localhost:8080/health
curl -X POST http://localhost:8080/execute
```

## Project Structure

```
src/
├── main/java/com/example/bajaj/
│   ├── BajajApplication.java
│   ├── model/
│   │   ├── FinalQueryPayload.java
│   │   └── WebhookResponse.java
│   └── service/
│       └── WebhookService.java
└── test/java/com/example/bajaj/
    ├── BajajApplicationTest.java
    └── service/
        └── WebhookServiceIntegrationTest.java
```

## Download JAR

Direct download: [bajaj-1.0.0.jar](https://github.com/YOUR_USERNAME/bajaj-spring-boot-project/raw/main/target/bajaj-1.0.0.jar)


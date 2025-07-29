# Bajaj Spring Boot Project - Webhook Service Application

## 🔗 GitHub Repository

- **Repository**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project`
- **Clone URL**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project.git`
- **JAR Download**: [Download JAR](https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar)
- **Raw JAR URL**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project/raw/main/target/bajaj-1.0.0.jar`

> **Note**: Replace `YOUR_USERNAME` with your actual GitHub username after creating the repository.

## 📦 Quick Start

### Option 1: Download and Run JAR
```bash
# Download the JAR file
wget https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar

# Run the application
java -jar bajaj-1.0.0.jar
```

### Option 2: Clone and Build
```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/bajaj-springboot-project.git
cd bajaj-springboot-project

# Run directly from JAR
java -jar target/bajaj-1.0.0.jar

# Or build from source
mvn clean package
java -jar target/bajaj-1.0.0.jar
```

## � JAR File Information

- **File Name**: `bajaj-1.0.0.jar`
- **Size**: ~19MB (includes all dependencies)
- **Java Version**: Requires Java 22+
- **Location**: `target/bajaj-1.0.0.jar`
- **Type**: Executable Spring Boot JAR (Fat JAR)

### Direct Download Links
- **GitHub Release**: [Download v1.0.0](https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar)
- **Raw GitHub URL**: `https://github.com/YOUR_USERNAME/bajaj-springboot-project/raw/main/target/bajaj-1.0.0.jar`

### Download via Command Line
```bash
# Using wget
wget https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar

# Using curl
curl -LO https://github.com/YOUR_USERNAME/bajaj-springboot-project/releases/download/v1.0.0/bajaj-1.0.0.jar
```

## �📋 Prerequisites
- Java 22 or higher
- Maven 3.6 or higher

## Project Structure
```
bajaj_springboot_project/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/bajaj/
│   │           ├── BajajApplication.java
│   │           ├── model/
│   │           │   ├── FinalQueryPayload.java
│   │           │   └── WebhookResponse.java
│   │           └── service/
│   │               └── WebhookService.java
│   └── test/
│       └── java/
│           └── com/example/bajaj/
│               ├── BajajApplicationTest.java
│               └── service/
│                   └── WebhookServiceIntegrationTest.java
```

## How to Build and Run

### 1. Clean and Compile
```bash
mvn clean compile
```

### 2. Run Tests
```bash
mvn test
```

### 3. Start the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Available Endpoints

### Health Check
- **URL**: `GET http://localhost:8080/health`
- **Description**: Returns application health status
- **Response**: `"Application is running!"`

### Execute Webhook Flow
- **URL**: `POST http://localhost:8080/execute`
- **Description**: Triggers the webhook execution flow
- **Response**: Success message or error details

## Testing the Application

### Using curl:

1. **Test Health Endpoint:**
   ```bash
   curl -X GET http://localhost:8080/health
   ```

2. **Test Webhook Execution:**
   ```bash
   curl -X POST http://localhost:8080/execute
   ```

### Automated Tests:

The project includes both unit and integration tests:

- **BajajApplicationTest**: Tests application context loading
- **WebhookServiceIntegrationTest**: Tests REST endpoints functionality

Run all tests with:
```bash
mvn test
```

## Expected Behavior

- The application starts successfully on port 8080
- Health endpoint returns a 200 OK response
- Webhook execution endpoint handles external API calls and returns appropriate error messages when the external service is unavailable or returns authentication errors
- All tests pass successfully

## Notes

- The webhook service attempts to call external APIs which may require authentication
- Error handling is implemented to gracefully handle API failures
- The application is configured for Java 22 with Spring Boot 3.3.0
- Integration tests run on a random port to avoid conflicts

## Troubleshooting

If you encounter any issues:

1. Ensure Java 22+ is installed: `java --version`
2. Ensure Maven is installed: `mvn --version`
3. Check if port 8080 is available
4. Review logs for any specific error messages

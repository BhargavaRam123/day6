# Day 6 - Spring MVC REST API Project

A hands-on Spring MVC REST API project demonstrating various HTTP methods and request handling techniques using embedded Tomcat.

## Project Overview

This project implements a simple REST API using **Spring Framework 6.1.14** without Spring Boot. It runs on an **embedded Tomcat server** and demonstrates different ways to handle HTTP requests in Spring MVC.

## Technologies Used

- **Java 17**
- **Spring Framework 6.1.14** (Spring MVC)
- **Tomcat 10.1.26** (Embedded)
- **Jackson 2.17.2** (JSON serialization)
- **Maven 3.x**
- **JUnit 5** (Testing)

## Project Structure

```
day6/
├── src/
│   ├── main/
│   │   └── java/org/example/
│   │       ├── App.java                    # Main entry point (embedded Tomcat)
│   │       ├── Main.java                   # Sample main class
│   │       ├── controller/
│   │       │   └── HelloController.java    # REST endpoints
│   │       ├── config/
│   │       │   └── WebConfig.java          # Spring MVC configuration
│   │       └── dto/
│   │           └── UserDTO.java            # Data Transfer Object
│   └── test/
│       └── java/org/example/
│           └── controller/
│               └── HelloControllerTest.java # Unit tests
├── pom.xml                                  # Maven configuration
└── README.md                                # This file
```

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6 or later

### Building the Project

```bash
mvn clean install
```

### Running the Application

```bash
mvn exec:java -Dexec.mainClass="org.example.App"
```

Or run the `App.java` file directly from your IDE.

The server will start on **http://localhost:8080**

## API Endpoints

The application provides a `/hello` REST endpoint with 5 different use cases:

### UC1 - Basic GET Request
```
GET /hello
```
**Response:**
```
Hello from BridgeLabz
```

### UC2 - GET with Query Parameter
```
GET /hello/query?name=Mark
```
**Response:**
```
Hello Mark from BridgeLabz
```

### UC3 - GET with Path Variable
```
GET /hello/param/Mark
```
**Response:**
```
Hello Mark from BridgeLabz
```

### UC4 - POST with JSON Body
```
POST /hello/post
Content-Type: application/json

{
  "firstName": "Mark",
  "lastName": "Taylor"
}
```
**Response:**
```
Hello Mark Taylor from BridgeLabz
```

### UC5 - PUT with Path Variable and Query Parameter
```
PUT /hello/put/Mark?lastName=Taylor
```
**Response:**
```
Hello Mark Taylor from BridgeLabz
```

## Project Components

### App.java
The main entry point that:
- Initializes an embedded Tomcat server
- Configures the Spring DispatcherServlet
- Sets up the Spring web application context
- Runs the server on port 8080

### HelloController.java
REST controller that handles all HTTP requests:
- Uses Spring annotations (`@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`)
- Implements 5 use cases demonstrating different request handling techniques
- Returns plain text responses

### WebConfig.java
Spring configuration class that:
- Enables Spring MVC with `@EnableWebMvc`
- Performs component scanning for controller detection
- Configures JSON message converters via Jackson

### UserDTO.java
Data Transfer Object for handling JSON request bodies:
- Contains `firstName` and `lastName` fields
- Provides getters and setters for serialization/deserialization

## Testing

Run the test suite using:

```bash
mvn test
```

Unit tests are located in `src/test/java/org/example/controller/HelloControllerTest.java`

## Building and Packaging

### Package as JAR
```bash
mvn package
```

The packaged JAR will be created in the `target/` directory.

### Clean Build
```bash
mvn clean install
```

## Dependencies

### Core Dependencies
- **spring-webmvc** - Spring MVC framework
- **jackson-databind** - JSON processing
- **tomcat-embed-core** - Embedded Tomcat server
- **tomcat-embed-jasper** - JSP support

### Test Dependencies
- **junit-jupiter** - JUnit 5 testing framework

## Configuration Details

### Tomcat Configuration
- **Port:** 8080
- **Context Path:** "/" (root context)
- **Server Base Directory:** Java temp directory

### Spring Configuration
- **Component Scan:** `org.example`
- **Message Converters:** Auto-configured by Spring MVC when Jackson is on classpath

## Key Learning Points

This project demonstrates:
1. **Spring MVC without Spring Boot** - Manual configuration approach
2. **Embedded Tomcat** - Running a web server without external installation
3. **RESTful API Design** - Various HTTP methods and request/response patterns
4. **Request Mapping** - Using path variables, query parameters, and request bodies
5. **DTO Pattern** - Data transfer objects for JSON serialization

## IDE Support

This project is fully compatible with:
- IntelliJ IDEA
- Eclipse
- VS Code (with Java extensions)

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, modify the port in `App.java`:
```java
int port = 8080;  // Change this value
```

### Maven Build Issues
Clear Maven cache:
```bash
mvn clean -U install
```

### Jackson Configuration
Jackson is automatically detected and configured. If JSON serialization fails, ensure `jackson-databind` is in the classpath.

## License

This is a learning project from BridgeLabz.


# DTH Data Service

A Spring Boot REST API service for managing DTH (Data Transfer Hub) and Numpy data.

## Overview

This service provides endpoints for:
- Retrieving numpy data arrays
- Retrieving DTH data records
- Updating DTH data
- Deleting DTH data

## Project Structure

```
dth-data-service/
├── src/
│   ├── main/
│   │   ├── java/com/dth/
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── service/         # Business logic services
│   │   │   ├── model/           # Data models
│   │   │   └── DthDataServiceApplication.java
│   │   └── resources/
│   │       └── application.yml  # Configuration
│   └── test/
├── pom.xml                      # Maven dependencies
└── README.md
```

## Endpoints

### 1. Get Numpy Data
- **URL:** `GET /api/data/numpy-data`
- **Description:** Retrieve all numpy data arrays
- **Response:** Returns a list of numpy data objects

**Example Response:**
```json
{
  "status": 200,
  "message": "Numpy data retrieved successfully",
  "data": [
    {
      "id": "numpy_001",
      "title": "Sample Numpy Array",
      "values": [1.0, 2.0, 3.0, 4.0, 5.0],
      "dataType": "float64",
      "shape": 5
    }
  ],
  "timestamp": "2026-01-07T10:30:00"
}
```

### 2. Get DTH Data
- **URL:** `GET /api/data/dth-data`
- **Description:** Retrieve all DTH data records
- **Response:** Returns a map of DTH data objects

**Example Response:**
```json
{
  "status": 200,
  "message": "DTH data retrieved successfully",
  "data": {
    "1": {
      "id": 1,
      "name": "Sample DTH Data",
      "description": "Initial sample data",
      "data": "Sample content",
      "createdAt": "2026-01-07T10:00:00",
      "updatedAt": "2026-01-07T10:00:00"
    }
  },
  "timestamp": "2026-01-07T10:30:00"
}
```

### 3. Update DTH Data
- **URL:** `POST /api/data/update-dth-data`
- **Description:** Update an existing DTH data record
- **Method:** POST
- **Request Body:**
```json
{
  "id": 1,
  "name": "Updated Name",
  "description": "Updated description",
  "data": "Updated content"
}
```

**Example Response:**
```json
{
  "status": 200,
  "message": "DTH data updated successfully",
  "data": {
    "id": 1,
    "name": "Updated Name",
    "description": "Updated description",
    "data": "Updated content",
    "createdAt": "2026-01-07T10:00:00",
    "updatedAt": "2026-01-07T10:35:00"
  },
  "timestamp": "2026-01-07T10:35:00"
}
```

### 4. Delete DTH Data
- **URL:** `POST /api/data/delete-dth-data?id={id}`
- **Description:** Delete a DTH data record by ID
- **Method:** POST
- **Query Parameters:** `id` (Long) - The ID of the record to delete

**Example Response:**
```json
{
  "status": 200,
  "message": "DTH data deleted successfully",
  "data": "ID: 1",
  "timestamp": "2026-01-07T10:40:00"
}
```

## Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

## Build and Run

### Using Maven

**Build the project:**
```bash
mvn clean package
```

**Run the application:**
```bash
mvn spring-boot:run
```

Or run the JAR file:
```bash
java -jar target/dth-data-service-1.0.0.jar
```

The service will start on `http://localhost:8080`

## Configuration

The application is configured via [application.yml](src/main/resources/application.yml):

- **Server Port:** 8080
- **Context Path:** /api
- **Log Level:** INFO (DEBUG for com.dth package)

## Dependencies

- Spring Boot 3.2.0
- Spring Web
- Lombok
- JUnit 5 (for testing)

## Sample Requests

### Get all Numpy Data
```bash
curl -X GET http://localhost:8080/api/data/numpy-data
```

### Get all DTH Data
```bash
curl -X GET http://localhost:8080/api/data/dth-data
```

### Update DTH Data
```bash
curl -X POST http://localhost:8080/api/data/update-dth-data \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "name": "New Name",
    "description": "New description",
    "data": "New data"
  }'
```

### Delete DTH Data
```bash
curl -X POST http://localhost:8080/api/data/delete-dth-data?id=1
```

## License

This project is open source and available under the MIT License.
# dth-service

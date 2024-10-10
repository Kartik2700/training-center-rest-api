# Training Center API

This project is a RESTful API for managing training centers. It allows to create and retrieve information about training centers.

## Features

- Create new training centers.
- Retrieve information about all training centers.

## Endpoints

### Create a Training Center

- **URL:** `http://localhost:8080/api/training-centers`
- **Method:** `POST`
- **Description:** This endpoint allows you to create a new training center.
- **Request Body:**
    ```json
    {
      "centerCode": "ABC123456789",
      "centerName": "Example Training Center",
      "address": {
        "detailedAddress": "123 Example St",
        "city": "Example City",
        "state": "Example State",
        "pincode": "123456"
      },
      "studentCapacity": 100,
      "coursesOffered": ["Course 1", "Course 2"],
      "contactEmail": "example@domain.com",
      "contactPhone": "9876543210"
    }
    ```
- **Response:**
    - **Success (201 Created):**
        ```json
        {
          "centerCode": "ABC123456789",
          "centerName": "Example Training Center",
          ...
        }
        ```
    - **Error (4xx/5xx):** Error details in JSON format.

### Get All Training Centers

- **URL:** `http://localhost:8080/api/training-centers`
- **Method:** `GET`
- **Description:** This endpoint retrieves all training centers.
- **Response:**
    - **Success (200 OK):**
        ```json
        [
          {
            "centerCode": "ABC123456789",
            "centerName": "Example Training Center",
            ...
          },
          ...
        ]
        ```

## Getting Started

### Prerequisites

- Java 21 (or higher)
- Maven
- PostgreSQL database

### Installation

1. **Clone the repository:**
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2. **Update the database configuration:**
   - Edit the `src/main/resources/application.properties` file to set your PostgreSQL credentials.

3. **Build the project:**
    ```sh
    mvn clean install
    ```

4. **Run the application:**
    ```sh
    mvn spring-boot:run
    ```


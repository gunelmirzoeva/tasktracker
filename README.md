                            Task Tracker REST API
            A Spring Boot REST API for managing tasks with support for creating, updating, deleting, and retrieving tasks.
            The project includes integration tests with an in-memory H2 database and follows best practices with DTOs, 
            exception handling, and validation.


            🚀 Features

            ✅ Create a new task
            ✏️ Update an existing task
            ❌ Delete a task
            🔄 Update task status (TODO, IN_PROGRESS, DONE)
            📋 List all tasks
            📌 Filter tasks by status
            ⚡ Integration tests with H2 database


            🛠️ Tech Stack

            Java 17
            Spring Boot 3.5
            Spring Web
            Spring Data JPA
            Spring Validation
            H2 Database (for testing)
            PostgreSQL (for production)
            MapStruct (DTO ↔ Entity mapping)
            Lombok (boilerplate reduction)
            OpenAPI / Swagger UI
            JUnit 5 & MockMvc (integration tests)

            📂 Project Structure
            src/main/java/com/example/tasktracker
            ┣ controller      # REST Controllers
            ┣ dto             # DTOs for request/response
            ┣ entity          # JPA Entities
            ┣ enums           # Enum classes (e.g. Status)
            ┣ exception       # Custom exceptions & handlers
            ┣ mapper          # MapStruct mappers
            ┣ repository      # Spring Data JPA repositories
            ┣ service         # Service interfaces
            ┣ service/impl    # Service implementations


            ⚙️ Getting Started

            1️ Clone the repository:

                git clone https://github.com/gunelmirzoeva/tasktracker.git
                cd tasktracker


            2️ Build the project
            
                ./gradlew clean build


            3️ Run the application
                
                ./gradlew bootRun

            By default, the app will run at:
            👉 http://localhost:8080

            
            📖 API Endpoints

            | Method     | Endpoint                                       | Description         |
            | ---------- | ---------------------------------------------- | ------------------- |
            | **POST**   | `/api/v1/tasks`                                | Create a new task   |
            | **PUT**    | `/api/v1/tasks/{id}`                           | Update a task       |
            | **DELETE** | `/api/v1/tasks/{id}`                           | Delete a task       |
            | **PATCH**  | `/api/v1/tasks/{id}/status?status=IN_PROGRESS` | Update status       |
            | **GET**    | `/api/v1/tasks`                                | Get all tasks       |
            | **GET**    | `/api/v1/tasks/status?status=TODO`             | Get tasks by status |

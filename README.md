# TAW24 - Gym Tracker API

TAW24 is a Spring Boot-based REST API designed to manage gym activities. It enables users to register exercises, track series and intensity, monitor progress, and manage diets. The application follows the MVC architecture pattern for clean separation of concerns.

## Features

* Register and manage exercises with detailed information
* Track workout series and intensity levels
* Monitor progress over time
* Add and manage diet plans
* Follows MVC architecture for maintainability and scalability

## Technologies Used

* Java 11+
* Spring Boot
* Spring MVC
* JPA/Hibernate
* MySQL (or configurable relational database)
* Maven

## Getting Started

### Prerequisites

* Java 11 or higher
* Maven
* MySQL or any compatible relational database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Croissanton/TAW24.git
   ```
2. Configure your database connection in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```
3. Build and run the application:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### API Endpoints

The API provides endpoints to manage exercises, series, diets, and progress tracking. (Add detailed endpoints here or link to API documentation if available.)

## Architecture

The application uses the Model-View-Controller (MVC) pattern:

* **Model:** Entity classes and database interactions
* **View:** REST controllers managing HTTP requests and responses
* **Controller:** Business logic and service layer

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for review.

## License

This project is licensed under the MIT License.

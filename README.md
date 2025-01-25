# Sort Waste REST API

This is a Spring Boot application that provides a REST API for managing waste categories, including disposal guidelines and recycling tips.

## Features
- **CRUD Operations**: Create, Retrieve, Update, and Delete waste categories.
- **Validation**: Ensures incoming data is valid using Spring Boot validation annotations.
- **Structured Responses**: JSON-formatted responses for all endpoints.

---

## Requirements

1. **Java**: JDK 17 or later.
2. **Maven**: Apache Maven for building and managing dependencies.
3. **IDE**: IntelliJ IDEA (recommended) or Eclipse.
4. **Postman**: For testing APIs (optional).

---

## Installation and Setup

### Step 1: Clone the Repository
```bash
# Clone this repository
$ git clone <repository-url>
$ cd <repository-folder>
```

### Step 2: Build the Project
```bash
# Build the project using Maven
$ mvn clean install
```

### Step 3: Run the Application
```bash
# Run the Spring Boot application
$ mvn spring-boot:run
```

### Step 4: Access the Application
- The application will be running on `http://localhost:8080`.

---

## API Endpoints

### Base URL: `/api/waste`

### 1. **Get All Waste Categories**
- **Endpoint**: `GET /categories`
- **Description**: Retrieves a list of all waste categories.
- **Response Example**:
```json
[
  {
    "id": 1,
    "name": "Plastic",
    "disposalGuidelines": "Dispose in blue bins.",
    "recyclingTips": "Clean and dry before recycling."
  }
]
```

### 2. **Get Waste Category by ID**
- **Endpoint**: `GET /categories/{id}`
- **Description**: Retrieves a specific waste category by its ID.
- **Response Example**:
```json
{
  "id": 1,
  "name": "Plastic",
  "disposalGuidelines": "Dispose in blue bins.",
  "recyclingTips": "Clean and dry before recycling."
}
```

### 3. **Create a New Waste Category**
- **Endpoint**: `POST /categories`
- **Description**: Creates a new waste category.
- **Request Body Example**:
```json
{
  "name": "Plastic",
  "disposalGuidelines": "Dispose in blue bins.",
  "recyclingTips": "Clean and dry before recycling."
}
```
- **Response Example**:
```json
{
  "id": 1,
  "name": "Plastic",
  "disposalGuidelines": "Dispose in blue bins.",
  "recyclingTips": "Clean and dry before recycling."
}
```

### 4. **Update an Existing Waste Category**
- **Endpoint**: `PUT /categories/{id}`
- **Description**: Updates an existing waste category by its ID.
- **Request Body Example**:
```json
{
  "name": "Paper",
  "disposalGuidelines": "Dispose in green bins.",
  "recyclingTips": "Ensure it is not wet or soiled."
}
```

### 5. **Delete a Waste Category**
- **Endpoint**: `DELETE /categories/{id}`
- **Description**: Deletes a waste category by its ID.
- **Response**: `204 No Content`

---

## Validation Rules
- **Name**: Cannot be blank.
- **Disposal Guidelines**: Cannot be blank.
- **Recycling Tips**: Cannot be blank.

---

## Example Usage

### Create a New Waste Category
1. Open Postman or any API testing tool.
2. Set the request method to `POST`.
3. Use the endpoint: `http://localhost:8080/api/waste/categories`.
4. Add the JSON body:
```json
{
  "name": "Glass",
  "disposalGuidelines": "Dispose in white bins.",
  "recyclingTips": "Remove caps and rinse thoroughly."
}
```
5. Send the request.

### Update an Existing Category
- Use the `PUT` method with a similar approach to update an existing category.

### Delete a Category
- Use the `DELETE` method to remove a category by its ID.

---

## Contributing
Feel free to fork the repository and submit pull requests for improvements.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

---

## Support
For questions or help, open an issue in the repository or contact the maintainer.


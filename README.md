# 🍽️ Recipe Backend (Spring Boot API)

This is the backend API built with **Spring Boot**. It connects to **TheMealDB API** to fetch meal data and allows users to save their favorite recipes in a MySQL database.

## 🚀 Features:
- Search for meals from **TheMealDB API**
- Save favorite recipes in **MySQL**
- Retrieve saved recipes
- Delete recipes from the database

## 🔧 Setup Instructions:

### 1️⃣ Install `MAMP` (if not installed)
Download and install `MAMP` to set up a local MySQL database.  
🔗 [Download MAMP](https://www.mamp.info/en/)

### 2️⃣ Create a MySQL Database
Run the following SQL command in your MySQL client:
```sql
CREATE DATABASE recipe_user;

3️⃣ Configure Database Credentials

Modify the database connection details in src/main/resources/application.properties if needed:
spring.datasource.url=jdbc:mysql://localhost:8889/recipe_user
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

4️⃣ Run the Backend Server
./mvnw spring-boot:run

5️⃣ Test API Endpoints in Postman

Use Postman or any API testing tool to test the backend endpoints:
	•	Search for a meal:
GET http://localhost:8080/api/recipes/search/{mealName}
	•	Save a meal:
POST http://localhost:8080/api/recipes/save
Body (JSON format):
{
  "recipeId": "52772",
  "recipeName": "Teriyaki Chicken",
  "category": "Chicken",
  "instructions": "Mix all ingredients and cook on medium heat...",
  "imageUrl": "https://www.themealdb.com/images/media/meals/teriyaki.jpg"
}
	•	Get all saved meals:
GET http://localhost:8080/api/recipes
	•	Delete a meal by ID:
DELETE http://localhost:8080/api/recipes/{id}


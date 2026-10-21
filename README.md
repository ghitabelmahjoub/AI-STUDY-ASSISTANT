# AI Study Assistant 📚

An Android-based study assistant project with a Java mobile application and a Node.js backend. The project includes a chat interface, user registration and login, and MySQL database integration.

## ✨ Features

- **User Registration:** Create an account with a username, password, and optional email.
- **User Login:** Authenticate users using their credentials.
- **Password Security:** Hash passwords using `bcryptjs` before storing them in the database.
- **Token-Based Authentication:** Generate JSON Web Tokens (JWTs) upon successful registration or login.
- **Chat Interface:** Android chat components for displaying messages.
- **Backend API:** REST endpoints connecting the Android application to the backend.
- **Database Integration:** MySQL connection for storing and retrieving user information.

## 🛠️ Technologies Used

### Android Application
- Java
- Android SDK
- Gradle
- Retrofit for HTTP API communication

### Backend
- Node.js
- Express.js
- MySQL
- `mysql2`
- `bcryptjs`
- `jsonwebtoken`
- `dotenv`
- `cors`

## 🏗️ Project Structure

```text
AI-STUDY-ASSISTANT/
├── app/
│   └── src/
│       ├── main/
│       │   ├── assets/
│       │   ├── java/
│       │   │   └── com/example/aistudyassistant/
│       │   │       ├── ApiService.java
│       │   │       ├── AuthResponse.java
│       │   │       ├── ChatMessage.java
│       │   │       ├── LoginActivity.java
│       │   │       ├── LoginRequest.java
│       │   │       ├── MainActivity.java
│       │   │       ├── MessageAdapter.java
│       │   │       ├── RegisterActivity.java
│       │   │       ├── RegisterRequest.java
│       │   │       └── RetrofitClient.java
│       │   ├── res/
│       │   └── AndroidManifest.xml
│       └── test/
├── backend/
│   ├── package.json
│   ├── package-lock.json
│   └── server.js
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
└── README.md
```

## 🔌 Backend API

The backend exposes the following endpoints:

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/register` | Register a new user |
| `POST` | `/api/login` | Authenticate an existing user |

### Registration

Example request:

```json
{
  "username": "student123",
  "password": "your_password",
  "email": "student@example.com"
}
```

### Login

Example request:

```json
{
  "username": "student123",
  "password": "your_password"
}
```

Successful authentication returns a response containing a JWT, the user's ID, and username.

## ⚙️ Setup and Installation

### Prerequisites

- Android Studio
- JDK compatible with the project's Gradle configuration
- Node.js and npm
- MySQL Server

### 1. Clone the Repository

```bash
git clone https://github.com/ghitabelmahjoub/AI-STUDY-ASSISTANT.git
cd AI-STUDY-ASSISTANT
```

### 2. Configure the MySQL Database

Create the database:

```sql
CREATE DATABASE ai_study_assistant;
```

Create a `users` table matching the fields used by the backend:

```sql
USE ai_study_assistant;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL
);
```

### 3. Configure Backend Environment Variables

Navigate to the backend directory:

```bash
cd backend
npm install
```

Create a local `.env` file with your own database credentials and JWT secret:

```env
DB_HOST=localhost
DB_USER=your_mysql_username
DB_PASSWORD=your_mysql_password
DB_NAME=ai_study_assistant
JWT_SECRET=replace_with_a_long_random_secret
PORT=3000
```

**Important:** Configure `server.js` to read these environment variables instead of using hardcoded credentials. Never commit `.env` or publish real passwords, API keys, or JWT secrets.

### 4. Start the Backend

```bash
node server.js
```

The server is configured to use port `3000` by default.

### 5. Run the Android Application

1. Open the repository in Android Studio.
2. Allow Gradle to synchronize the project.
3. Configure the API base URL in `RetrofitClient.java` to point to your running backend.
4. Run the application on an Android emulator or compatible device.

For the Android emulator, the host machine is usually reachable at `10.0.2.2` rather than `localhost`. For a physical device, configure the appropriate computer LAN IP and ensure both devices can communicate.

## 🔒 Security Considerations

- Passwords are hashed before being stored in MySQL.
- JWTs are used to represent successful authentication.
- Keep database credentials and signing secrets outside the source code.
- Use HTTPS and appropriate token validation for production deployments.
- Validate inputs and return appropriate HTTP status codes from the backend.

## 🚀 Future Improvements

- Integrate and document the AI-powered question-answering functionality.
- Add secure token storage and session handling in the Android application.
- Improve API error handling and input validation.
- Add automated backend tests.
- Add application screenshots and a demonstration of the main user flows.

## 👩‍💻 Author

**Ghita Belmahjoub**

GitHub: [@ghitabelmahjoub](https://github.com/ghitabelmahjoub)

---

*This project demonstrates Android application development, REST API integration, backend authentication, and relational database connectivity.*

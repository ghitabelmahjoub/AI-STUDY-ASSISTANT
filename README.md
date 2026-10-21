# AI Study Assistant 📚

An Android study assistant application built with **Java, Node.js, Express.js, and MySQL**. The project combines a mobile chat interface with a REST API backend, user registration, and token-based authentication.

This project demonstrates Android development, API integration, backend authentication, and relational database management.

## ✨ Features

- **User Registration:** Create an account with a username, password, and email.
- **User Login:** Authenticate users using their credentials.
- **Password Hashing:** Hash passwords using `bcryptjs` before storing them in MySQL.
- **JWT Authentication:** Issue JSON Web Tokens after successful registration or login.
- **Chat Interface:** Display chat messages using Android UI components.
- **REST API:** Connect the Android application to the Node.js backend.
- **MySQL Integration:** Store and retrieve user account information.
- **Environment-Based Configuration:** Keep database credentials and JWT secrets outside the source code.

## 🛠️ Technologies Used

| Component | Technologies |
|---|---|
| Android application | Java, Android SDK |
| API communication | Retrofit |
| Backend | Node.js, Express.js |
| Database | MySQL, `mysql2` |
| Authentication | `bcryptjs`, `jsonwebtoken` |
| Configuration | `dotenv` |
| Development tools | Android Studio, Gradle, npm |

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
│   ├── .env.example
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

The backend exposes the following authentication endpoints:

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/register` | Register a new user |
| `POST` | `/api/login` | Authenticate an existing user |

### Registration

Example JSON request:

```json
{
  "username": "student123",
  "password": "your_password",
  "email": "student@example.com"
}
```

### Login

Example JSON request:

```json
{
  "username": "student123",
  "password": "your_password"
}
```

Successful authentication returns a response containing a success status, a JWT, the user ID, and the username.

## ⚙️ Setup and Installation

### Prerequisites

- Android Studio
- A JDK compatible with the project's Gradle configuration
- Node.js and npm
- MySQL Server

### 1. Clone the repository

```bash
git clone https://github.com/ghitabelmahjoub/AI-STUDY-ASSISTANT.git
cd AI-STUDY-ASSISTANT
```

### 2. Configure the MySQL database

Create the database in MySQL:

```sql
CREATE DATABASE ai_study_assistant;
```

Create the users table:

```sql
USE ai_study_assistant;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL
);
```

If the table already exists, check its structure before running the creation statement again.

### 3. Configure the backend

Open a terminal in the backend directory:

```bash
cd backend
npm install
```

Create your local environment file by copying the provided template.

**Windows PowerShell:**

```powershell
Copy-Item .env.example .env
```

Edit `backend/.env` and enter your own local database credentials and a strong, randomly generated JWT secret:

```env
DB_HOST=localhost
DB_USER=your_mysql_username
DB_PASSWORD=your_mysql_password
DB_NAME=ai_study_assistant
JWT_SECRET=your_generated_random_secret
PORT=3000
```

Keep the `.env` file private. Never commit database passwords, JWT secrets, or other credentials to GitHub.

### 4. Start the backend

From the `backend` directory, run:

```bash
node server.js
```

By default, the API listens on port `3000`.

The available authentication endpoints are:

- `http://localhost:3000/api/register`
- `http://localhost:3000/api/login`

These endpoints accept POST requests.

### 5. Run the Android application

1. Open the repository in Android Studio.
2. Allow Gradle to synchronize the project.
3. Confirm that the backend is running.
4. Configure the API base URL in `RetrofitClient.java` for your testing environment.
5. Run the application on an Android emulator or compatible Android device.

**Networking note:** An Android emulator commonly reaches the host computer through `10.0.2.2` rather than `localhost`. For a physical device, configure the computer's reachable local network IP and ensure the required network permissions and firewall rules are in place.

## 🔒 Security Considerations

- Passwords are hashed before being stored in the database.
- JWTs are issued following successful authentication.
- Database credentials and signing secrets are configured through environment variables.
- Local environment files must remain excluded from version control.
- Production deployments should use HTTPS, suitable token validation, input validation, and appropriate error handling.

## 🚀 Future Improvements

- Integrate an AI-powered question-and-answer service into the chat interface.
- Improve token storage and session management in the Android application.
- Add automated backend tests.
- Strengthen input validation and API error handling.
- Add application screenshots and a demonstration of the main user flows.

## 👩‍💻 Author

**Ghita Belmahjoub**

GitHub: [@ghitabelmahjoub](https://github.com/ghitabelmahjoub)

---

*This project demonstrates Android application development, REST API integration, backend authentication, and relational database connectivity.*

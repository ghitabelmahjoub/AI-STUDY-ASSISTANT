# AI Study Assistant 📚

An Android study assistant application built with **Java, Android SDK, Node.js, Express.js, and MySQL**. It combines a mobile chat interface with a backend REST API for user registration and authentication.

## Features

- User registration and login
- Password hashing with bcryptjs
- JWT-based authentication
- Android chat interface
- REST API integration using Retrofit
- MySQL database integration
- Environment-based backend configuration

## Technologies

| Component | Technologies |
|---|---|
| Mobile app | Java, Android SDK |
| API integration | Retrofit |
| Backend | Node.js, Express.js |
| Database | MySQL, mysql2 |
| Authentication | bcryptjs, jsonwebtoken |
| Configuration | dotenv |
| Tools | Android Studio, Gradle, npm |

## Project Structure

```text
AI-STUDY-ASSISTANT/
├── app/
├── backend/
│   ├── .env.example
│   ├── package.json
│   ├── package-lock.json
│   └── server.js
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Backend API

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/register` | Register a new user |
| POST | `/api/login` | Authenticate a user |

Successful authentication returns a response containing a JWT and user information.

## Setup

### Prerequisites

- Android Studio and a compatible JDK
- Node.js and npm
- MySQL Server

### 1. Clone the repository

```bash
git clone https://github.com/ghitabelmahjoub/AI-STUDY-ASSISTANT.git
cd AI-STUDY-ASSISTANT
```

### 2. Configure the database

Create the database in MySQL:

```sql
CREATE DATABASE ai_study_assistant;
```

If you haven't created the users table yet, use:

```sql
USE ai_study_assistant;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NULL
);
```

If the table already exists, do not create it again.

### 3. Configure the backend

In PowerShell:

```powershell
cd backend
Copy-Item .env.example .env
npm install
```

Edit `backend/.env` with your local MySQL credentials and a strong, private JWT secret.

```env
DB_HOST=localhost
DB_USER=your_mysql_username
DB_PASSWORD=your_mysql_password
DB_NAME=ai_study_assistant
JWT_SECRET=your_private_random_secret
PORT=3000
```

Never commit your `.env` file or share its secrets.

### 4. Start the backend

From the `backend` directory, run:

```bash
node server.js
```

The API runs on port `3000` by default.

### 5. Run the Android app

1. Open the project in Android Studio.
2. Sync Gradle and run the app.
3. Ensure the backend is running.
4. Check the base URL in `RetrofitClient.java`.

For the standard Android emulator, use `10.0.2.2` to access your computer's localhost. For a physical device, use your computer's local network IP address.

## Security

- Passwords are hashed before database storage.
- JWTs are used for authentication.
- Database credentials and JWT secrets are loaded from environment variables.
- The local `.env` file should remain excluded from Git.

For production deployment, use HTTPS, validate inputs, and securely manage tokens and secrets.

## Future Improvements

- Connect the chat interface to an AI question-answering service.
- Improve session and token management.
- Add automated tests and more detailed error handling.
- Add screenshots demonstrating the application.

## Author

**Ghita Belmahjoub**

GitHub: [@ghitabelmahjoub](https://github.com/ghitabelmahjoub)

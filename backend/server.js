require('dotenv').config();
const express = require('express');
const mysql = require('mysql2');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

// Database connection
const db = mysql.createPool({
    host: process.env.DB_HOST || 'localhost',
    user: process.env.DB_USER || 'root',
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME || 'ai_study_assistant',
    waitForConnections: true,
    connectionLimit: 10
});

const promisePool = db.promise();

// ==================== REGISTER ====================
app.post('/api/register', async (req, res) => {
    try {
        const { username, password, email } = req.body;
        
        if (!username || !password) {
            return res.json({ success: false, message: 'Username and password required' });
        }
        
        const [existing] = await promisePool.query('SELECT id FROM users WHERE username = ?', [username]);
        if (existing.length > 0) {
            return res.json({ success: false, message: 'Username already exists' });
        }
        
        const hashedPassword = await bcrypt.hash(password, 10);
        
        const [result] = await promisePool.query(
            'INSERT INTO users (username, password, email) VALUES (?, ?, ?)',
            [username, hashedPassword, email || null]
        );
        
       const token = jwt.sign(
    { id: result.insertId, username },
    process.env.JWT_SECRET,
    { expiresIn: '7d' }
);
        
        res.json({ 
            success: true, 
            message: 'Registration successful', 
            token, 
            userId: result.insertId, 
            username 
        });
        
    } catch (error) {
        console.error(error);
        res.json({ success: false, message: 'Server error' });
    }
});

// ==================== LOGIN ====================
app.post('/api/login', async (req, res) => {
    try {
        const { username, password } = req.body;
        
        if (!username || !password) {
            return res.json({ success: false, message: 'Username and password required' });
        }
        
        const [users] = await promisePool.query('SELECT id, username, password FROM users WHERE username = ?', [username]);
        
        if (users.length === 0) {
            return res.json({ success: false, message: 'Invalid username or password' });
        }
        
        const user = users[0];
        const valid = await bcrypt.compare(password, user.password);
        
        if (!valid) {
            return res.json({ success: false, message: 'Invalid username or password' });
        }
        
     const token = jwt.sign(
    { id: user.id, username: user.username },
    process.env.JWT_SECRET,
    { expiresIn: '7d' }
);
        
        res.json({ 
            success: true, 
            message: 'Login successful', 
            token, 
            userId: user.id, 
            username: user.username 
        });
        
    } catch (error) {
        console.error(error);
        res.json({ success: false, message: 'Server error' });
    }
});

// ==================== START SERVER ====================
const PORT = 3000;
app.listen(PORT, () => {
    console.log(`✅ Server running on http://localhost:${PORT}`);
    console.log(`📝 Register: POST http://localhost:${PORT}/api/register`);
    console.log(`🔐 Login: POST http://localhost:${PORT}/api/login`);
});

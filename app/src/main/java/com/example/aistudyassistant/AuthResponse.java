package com.example.aistudyassistant;

public class AuthResponse {
    private boolean success;
    private String message;
    private String token;
    private int userId;
    private String username;

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public String getToken() { return token; }
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
}
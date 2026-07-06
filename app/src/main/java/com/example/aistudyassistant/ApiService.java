package com.example.aistudyassistant;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("api/register")
    Call<AuthResponse> register(@Body RegisterRequest request);

    @POST("api/login")
    Call<AuthResponse> login(@Body LoginRequest request);
}
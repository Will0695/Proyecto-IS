package com.example.is_prueba100;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ApiService {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);
}

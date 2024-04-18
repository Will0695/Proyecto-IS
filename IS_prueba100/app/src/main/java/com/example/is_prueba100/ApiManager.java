package com.example.is_prueba100;
import android.content.Intent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    /**
     *
     */
    private ApiService apiService;
    public ApiManager() {
        // Inicializar Retrofit y ApiService
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-production-c57e.up.railway.app/api/login") // Reemplaza esto con la URL de tu API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void login(String username, String password, final LoginCallback callback) {
// Crear un objeto LoginRequest con el nombre de usuario y la contraseña
        LoginRequest loginRequest = new LoginRequest(username, password);

        // Hacer la llamada al método login() con el objeto LoginRequest
        Call<LoginResponse> call = apiService.login(loginRequest);

        // Realizar la llamada asíncrona a la API
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    // Verificar si el inicio de sesión fue exitoso
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.isSuccess()) {
                        callback.onSuccess();
                    } else {
                        callback.onFailure("Credenciales inválidas");
                    }
                } else {
                    callback.onFailure("Error en la solicitud");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onFailure("Error de red: " + t.getMessage());
            }
        });
    }

    // Interfaz de callback para el resultado del inicio de sesión
    public interface LoginCallback {
        void onSuccess();
              void onFailure(String errorMessage);
    }
}
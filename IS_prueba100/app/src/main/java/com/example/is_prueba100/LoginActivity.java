package com.example.is_prueba100;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private ApiManager apiManager;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializar ApiManager
        apiManager = new ApiManager();


    }

    private void loginUser() {
        // Obtener nombre de usuario y contraseña de los EditText
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Verificar si se han ingresado el nombre de usuario y la contraseña
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese el nombre de usuario y la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        // Llamar al método de inicio de sesión en ApiManager
        apiManager.login(username,
                password,
                new ApiManager.LoginCallback() {
                    @Override
                    public void onSuccess() {
                        // Iniciar la actividad HomeActivity después del inicio de sesión exitoso
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish(); // Finalizar la actividad actual para evitar que el usuario regrese a esta pantalla con el botón "Atrás"
                    }



                    @Override
                    public void onFailure(String errorMessage) {
                        // Manejar el fallo del inicio de sesión
                        Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
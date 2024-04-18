package com.example.is_prueba100;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_info);

        // Asociar el botón de inicio de sesión con la variable Java
        buttonLogin = findViewById(R.id.buttonLogin);

        // Agregar un Listener al botón de inicio de sesión
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de inicio de sesión cuando se presiona el botón
               // Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onLogoClick(View view) {
        // Define la actividad a la que deseas redirigir
        Intent intent = new Intent(this, info.class);
        // Inicia la nueva actividad
        startActivity(intent);
    }
}

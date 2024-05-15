package com.example.tpi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailField = findViewById(R.id.email);
        EditText passwordField = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                // Verifica daca emailul si parola sunt corecte
                if ("admin@example.com".equals(email) && "password".equals(password)) {
                    // Daca sunt corecte, porneste MainMenuActivity
                    Intent intent = new Intent(LoginScreen.this, MainMenuActivity.class);
                    startActivity(intent);
                    finish(); // Inchide activitatea curenta pentru a preveni revenirea la ea
                } else {
                    // Altfel, afiseaza un mesaj de eroare
                    Toast.makeText(LoginScreen.this, "Invalid email or password. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

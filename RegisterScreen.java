package com.example.tpi;

import android.content.Intent; // Pentru a naviga către altă activitate
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText emailField = findViewById(R.id.email);
        EditText usernameField = findViewById(R.id.username);
        EditText passwordField = findViewById(R.id.password);
        Button registerButton = findViewById(R.id.register_button);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();

                if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterScreen.this, "Vă rugăm să completați toate câmpurile.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterScreen.this, "Înregistrare reușită!", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(RegisterScreen.this, SetIncomeAndDateActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}

package com.example.tpi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterScreen1 extends AppCompatActivity {

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
                    Toast.makeText(RegisterScreen1.this, "Vă rugăm să completați toate câmpurile.", Toast.LENGTH_SHORT).show();
                } else {
                    // Trimite datele către server folosind clasa ServerCommunicator
                    new ServerCommunicator(RegisterScreen1.this) {
                        @Override
                        protected void onPostExecute(String result) {
                            // Verifică dacă contul a fost creat cu succes
                            if (result != null && result.equals("Cont creat cu succes!")) {
                                // Dacă da, treci la pagina SetIncomeAndDateActivity
                                Intent intent = new Intent(RegisterScreen1.this, MainMenuActivity.class);
                                startActivity(intent);
                            } else {
                                // Altfel, afișează un mesaj utilizatorului
                                Toast.makeText(RegisterScreen1.this, result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }.execute(email, username, password);
                }
            }
        });
    }
}

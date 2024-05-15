package com.example.tpi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Obțineți referințe către butoanele din layout
        Button settingsButton = findViewById(R.id.settings_button);
        Button addTransactionButton = findViewById(R.id.add_transaction_button);
        Button investmentsButton = findViewById(R.id.investments_button);
        Button setIncomeButton = findViewById(R.id.set_income_button); // Butonul nou adăugat

        // Setarea unui click listener pentru butonul de setări
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschideți activitatea de setări
                Intent intent = new Intent(MainMenuActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        // Setarea unui click listener pentru butonul de adăugare tranzacție
        addTransactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschideți activitatea de adăugare a tranzacției
                Intent intent = new Intent(MainMenuActivity.this, AddTransactionActivity.class);
                startActivity(intent);
            }
        });

        // Setarea unui click listener pentru butonul de investiții
        investmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschideți activitatea de investiții
                Intent intent = new Intent(MainMenuActivity.this, InvestmentsActivity.class);
                startActivity(intent);
            }
        });

        // Setarea unui click listener pentru butonul de setare a venitului
        setIncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deschideți activitatea de setare a venitului
                Intent intent = new Intent(MainMenuActivity.this, SetIncomeAndDateActivity.class);
                startActivity(intent);
            }
        });
    }
}

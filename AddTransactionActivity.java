package com.example.tpi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        EditText amountEditText = findViewById(R.id.edit_amount);
        EditText categoryEditText = findViewById(R.id.edit_category);
        EditText dateEditText = findViewById(R.id.edit_date);
        RadioGroup typeRadioGroup = findViewById(R.id.radio_group_type);
        Button addButton = findViewById(R.id.button_add_transaction);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verifica tipul de tranzacție selectat
                int selectedId = typeRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String type = selectedRadioButton.getText().toString();

                // Obține valorile introduse de utilizator
                String amount = amountEditText.getText().toString();
                String category = categoryEditText.getText().toString();
                String date = dateEditText.getText().toString();

                // Verifică dacă sunt introduse toate datele necesare
                if (!amount.isEmpty() && !category.isEmpty() && !date.isEmpty()) {
                    // Salvare și manipulare a datelor tranzacției
                    // Aici ar trebui să adaugi logica pentru gestionarea datelor tranzacției

                    // Exemplu de afișare a datelor introduse
                    String message = "Tranzacție adăugată:\nTip: " + type + "\nSumă: " + amount + "\nCategorie: " + category + "\nData: " + date;
                    Toast.makeText(AddTransactionActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddTransactionActivity.this, "Te rugăm să completezi toate câmpurile.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

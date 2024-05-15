package com.example.tpi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InitialSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_setup);


        LinearLayout incomeTypesContainer = findViewById(R.id.income_types_container);
        LinearLayout fixedExpensesContainer = findViewById(R.id.fixed_expenses_container);


        String[] incomeTypes = {"Salariu", "Pensie", "Bursă", "Cadouri"};
        for (String incomeType : incomeTypes) {
            addCheckBoxWithEditText(incomeTypesContainer, incomeType);
        }


        String[] fixedExpenseTypes = {"Abonamente", "Rate", "Facturi - Electricitate", "Facturi - Gaz", "Facturi - Internet"};
        for (String expenseType : fixedExpenseTypes) {
            addCheckBoxWithEditText(fixedExpensesContainer, expenseType);
        }


        Button completeSetupButton = findViewById(R.id.complete_setup);
        completeSetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder summary = new StringBuilder("Selected Income Types:\n");

                collectSelectionsWithSums(incomeTypesContainer, summary);

                summary.append("\nSelected Fixed Expenses:\n");
                collectSelectionsWithSums(fixedExpensesContainer, summary);

                Toast.makeText(InitialSetupActivity.this, summary.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addCheckBoxWithEditText(LinearLayout container, String label) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(label);
        EditText editText = new EditText(this);
        editText.setHint("Introduceți suma");
        editText.setInputType(android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL);


        container.addView(checkBox);
        container.addView(editText);
    }

    private void collectSelectionsWithSums(LinearLayout container, StringBuilder summary) {
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i += 2) { // Doi copii: CheckBox și EditText
            CheckBox checkBox = (CheckBox) container.getChildAt(i);
            EditText editText = (EditText) container.getChildAt(i + 1);

            if (checkBox.isChecked()) {
                String sum = editText.getText().toString();
                summary.append(checkBox.getText()).append(": ").append(sum.isEmpty() ? "0" : sum).append(" lei\n");
            }
        }
    }
}

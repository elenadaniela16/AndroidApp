package com.example.tpi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SetMonthlyExpensesActivity extends AppCompatActivity {

    private LinearLayout expensesContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_monthly_expenses);

        expensesContainer = findViewById(R.id.expenses_container);
        Button addExpenseButton = findViewById(R.id.add_expense_button);
        Button continueButton = findViewById(R.id.continue_button);


        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addExpenseField();
            }
        });


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        addExpenseField();
    }

    private void addExpenseField() {
        View expenseField = getLayoutInflater().inflate(R.layout.item_expense_field, expensesContainer, false);

        EditText expenseAmount = expenseField.findViewById(R.id.expense_amount);
        EditText expenseCategory = expenseField.findViewById(R.id.expense_category);
        EditText expenseDate = expenseField.findViewById(R.id.expense_date);

        expensesContainer.addView(expenseField);
    }
}

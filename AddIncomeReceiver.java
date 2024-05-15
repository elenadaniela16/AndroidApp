package com.example.tpi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class AddIncomeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("UserBudget", Context.MODE_PRIVATE);
        float monthlyIncome = sharedPreferences.getFloat("monthlyIncome", 0); // Venitul lunar


        Toast.makeText(context, "Venitul lunar adăugat: " + monthlyIncome, Toast.LENGTH_LONG).show();


    }
}

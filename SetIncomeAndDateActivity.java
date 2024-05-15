package com.example.tpi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class SetIncomeAndDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_income_and_date);

        EditText monthlyIncomeField = findViewById(R.id.monthly_income);
        NumberPicker dayPicker = findViewById(R.id.number_picker);
        Button confirmButton = findViewById(R.id.confirm_button);


        dayPicker.setMinValue(1);
        dayPicker.setMaxValue(31);

        confirmButton.setOnClickListener(view -> {
            String monthlyIncome = monthlyIncomeField.getText().toString();
            int incomeDay = dayPicker.getValue();

            if (!monthlyIncome.isEmpty() && Float.parseFloat(monthlyIncome) > 0) {

                SharedPreferences sharedPreferences = getSharedPreferences("UserBudget", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("monthlyIncome", Float.parseFloat(monthlyIncome));
                editor.putInt("incomeDay", incomeDay);
                editor.apply();

                setIncomeAlarm(getApplicationContext(), incomeDay);

                Toast.makeText(SetIncomeAndDateActivity.this, "Venitul lunar și ziua setate cu succes.", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(SetIncomeAndDateActivity.this, MainMenuActivity.class);
                startActivity(intent);
            } else {

                Toast.makeText(SetIncomeAndDateActivity.this, "Introduceți un venit lunar valid.", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void setIncomeAlarm(Context context, int day) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, AddIncomeReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        if (alarmManager != null) {
            alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY * 30,
                    pendingIntent
            );
        }
    }
}

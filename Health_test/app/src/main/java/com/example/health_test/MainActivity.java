package com.example.health_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner bir_years_sp;
    Spinner bir_months_sp;
    Spinner bir_days_sp;
    Spinner genders_sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Выключаем тёмную тему приложения
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        bir_years_sp = findViewById(R.id.birth_year_spinner);
        bir_months_sp = findViewById(R.id.birth_month_spinner);
        bir_days_sp = findViewById(R.id.birth_date_spinner);
        genders_sp = findViewById(R.id.gender_spinner);

        // Само выпадающее меню приложения
        String[] birth_years = new String[100];
        int start_y = 2021;
        for (int i=0; i < 100; i++) {
            birth_years[i] = String.valueOf(start_y - i);
        }

        String[] birth_months = new String[12];
        for (int j=0; j < 12; j++) {
            birth_months[j] = String.valueOf(getMonthForInt(j));
        }

        String[] birth_days = new String[31];
        for (int k=0; k < 31; k++) {
            birth_days[k] = String.valueOf(k + 1);
        }

        String[] genders = {"М", "Ж"};


        ArrayAdapter<String> spinnerArrayYears = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, birth_years);
        ArrayAdapter<String> spinnerArrayMonths = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, birth_months);
        ArrayAdapter<String> spinnerArrayDays = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, birth_days);
        ArrayAdapter<String> spinnerArrayGenders = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genders);

        spinnerArrayYears.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArrayMonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArrayDays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArrayGenders.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bir_years_sp.setAdapter(spinnerArrayYears);
        bir_months_sp.setAdapter(spinnerArrayMonths);
        bir_days_sp.setAdapter(spinnerArrayDays);
        genders_sp.setAdapter(spinnerArrayGenders);
    }

    public void ShowResults (View v) {
        EditText ques_three = findViewById(R.id.heart_rate_lie);
        EditText ques_six = findViewById(R.id.heart_rate_stand);

        if (ques_three.getText().length() > 0 && ques_six.getText().length() > 0) {
            int pulse_lie = Integer.parseInt(ques_three.getText().toString());
            int pulse_stand = Integer.parseInt(ques_six.getText().toString());

            Intent intent = new Intent(this, Results.class);

            int final_difference = Math.abs(pulse_stand - pulse_lie);

            String[] person_credentials = {
                    bir_days_sp.getSelectedItem().toString(),
                    bir_months_sp.getSelectedItem().toString(),
                    bir_years_sp.getSelectedItem().toString(),
                    genders_sp.getSelectedItem().toString()};

            intent.putExtra("pulse_lie", pulse_lie);
            intent.putExtra("pulse_stand", pulse_stand);
            intent.putExtra("final_difference", final_difference);
            intent.putExtra("credentials", person_credentials);

            startActivity(intent);
        }
    }

    String getMonthForInt(int num) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ru"));
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_exit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.images_work;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MyNotes extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    ListView lvNotes;
    EditText etCase;
    TextView category_number;

    int year, month, day, hour, minute;
    int myYear, myDay, myMonth, myHour, myMinute;

    ArrayList<String> lvList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);

        lvNotes = findViewById(R.id.lvFirst);
        etCase = findViewById(R.id.etTopic);

        category_number = findViewById(R.id.tvTopic);
        Intent intent = getIntent();

        category_number.setText(intent.getStringExtra("category"));
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case (R.id.btnDateTime):

                Calendar calendar = Calendar.getInstance();

                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MyNotes.this, MyNotes.this, year, month, day);
                datePickerDialog.show();
                break;

            case (R.id.btnAddTopic):

                lvList.add(myHour + ":" + myMinute + "  " + myDay + "-" + (myMonth + 1) + "-" + myYear + "   " + etCase.getText().toString());

                ArrayAdapter<String> listviewAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lvList);

                lvNotes.setAdapter(listviewAdapter);
            }
        }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        myYear = year;
        myDay = dayOfMonth;
        myMonth = month;

        Calendar c = Calendar.getInstance();

        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MyNotes.this, MyNotes.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        myHour = hourOfDay;
        myMinute = minute;

        Log.d("date", "Year: " + myYear + "\n" +
        "Month: " + (myMonth + 1) + "\n" +
        "Day: " + myDay + "\n" +
        "Hour: " + myHour + "\n" +
        "Minute: " + myMinute);

    }
}
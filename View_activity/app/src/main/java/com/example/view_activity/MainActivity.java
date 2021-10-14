package com.example.view_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;

    Button ok_btn, cnc_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        ok_btn = findViewById(R.id.ok_btn);
        cnc_btn = findViewById(R.id.cnc_btn);

        mainTextView = findViewById(R.id.main_textview);
        mainButton = findViewById(R.id.main_button);

        ok_btn.setOnClickListener(oclbtn);
        cnc_btn.setOnClickListener(oclbtn);

        mainTextView.setText("Set in Java!");

        super.onCreate(savedInstanceState);
    }

    View.OnClickListener oclbtn = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_btn:
                    mainTextView.setText("Нажата кнопка ОК");
                    Toast.makeText(getApplicationContext(),
                            "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                    break;

                case R.id.cnc_btn:
                    mainTextView.setText("Нажата кнопка Cancel");
                    Toast.makeText(getApplicationContext(),
                            "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

}

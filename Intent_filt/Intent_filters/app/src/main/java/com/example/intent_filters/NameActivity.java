package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        etName = findViewById(R.id.etName);
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.putExtra("name", etName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
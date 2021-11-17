package com.example.intent_filters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    EditText etLName;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLName = findViewById(R.id.etLName);
        tvName = findViewById(R.id.tvName);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case (R.id.btnTime):
                intent = new Intent("com.example.intent.action.showtime");
                intent.putExtra("lname", etLName.getText().toString());
                startActivity(intent);
                break;
            case (R.id.btnDate):
                intent = new Intent("com.example.intent.action.showdate");
                intent.putExtra("lname", etLName.getText().toString());
                startActivity(intent);
                break;
            case (R.id.btnName):
                intent = new Intent(this, NameActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null){
            return;
        }
        String name = data.getStringExtra("name");
        tvName.setText("Your name is " + name);
    }
}
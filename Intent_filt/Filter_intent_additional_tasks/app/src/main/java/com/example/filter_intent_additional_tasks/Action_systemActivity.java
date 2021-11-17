package com.example.filter_intent_additional_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Action_systemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_system);
    }

    @Override
    protected void onUserLeaveHint(){
        Toast toast = Toast.makeText(getApplicationContext(), "Нажата кнопка HOME",
                Toast.LENGTH_SHORT);
        toast.show();
        super.onUserLeaveHint();
    }
}
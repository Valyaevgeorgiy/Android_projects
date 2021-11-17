package com.example.doub_window;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = "States";
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity: onCreate()");

        etName = findViewById(R.id.etName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnActTwo):
                Intent intent_2 = new Intent(this, ActivityTwo.class);
                startActivity(intent_2);
                break;
            case (R.id.btnActThree):
                Intent intent_3 = new Intent(this, ActivityThree.class);
                startActivity(intent_3);
                break;
            case (R.id.btnActFour):
                Intent intent_4 = new Intent(this, ActivityFour.class);
                startActivity(intent_4);
                break;
            case (R.id.btnActName):
                Intent intent_name = new Intent(this, ActivityName.class);
                intent_name.putExtra("name", etName.getText().toString());
                startActivity(intent_name);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.menu_second):
                Intent intent_2 = new Intent(this, ActivityTwo.class);
                startActivity(intent_2);
                break;
            case (R.id.menu_third):
                Intent intent_3 = new Intent(this, ActivityThree.class);
                startActivity(intent_3);
                break;
            case (R.id.menu_fourth):
                Intent intent_4 = new Intent(this, ActivityFour.class);
                startActivity(intent_4);
                break;
            case (R.id.menu_name):
                Intent intent_name = new Intent(this, ActivityName.class);
                intent_name.putExtra("name", etName.getText().toString());
                startActivity(intent_name);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity: Start()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity: Resume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity: onRestart()");
    }

}
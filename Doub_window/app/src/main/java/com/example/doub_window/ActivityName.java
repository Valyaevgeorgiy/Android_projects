package com.example.doub_window;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityName extends AppCompatActivity {
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        tvName = findViewById(R.id.tvName);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tvName.setText("Your name is: " + name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.menu_main):
                Intent intent_2 = new Intent(this, MainActivity.class);
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
            case (R.id.menu_second):
                Intent intent_name = new Intent(this, ActivityTwo.class);
                startActivity(intent_name);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
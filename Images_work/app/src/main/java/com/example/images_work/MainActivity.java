package com.example.images_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnMyNotes_1):
                Intent first_category = new Intent(this, MyNotes.class);
                first_category.putExtra("category", "Срочные и важные дела");
                startActivity(first_category);
                break;

            case (R.id.btnMyNotes_2):
                Intent second_category = new Intent(this, MyNotes.class);
                second_category.putExtra("category", "Несрочные и важные дела");
                startActivity(second_category);
                break;

            case (R.id.btnMyNotes_3):
                Intent third_category = new Intent(this, MyNotes.class);
                third_category.putExtra("category", "Срочные и неважные дела");
                startActivity(third_category);
                break;

            case (R.id.btnMyNotes_4):
                Intent fourth_category = new Intent(this, MyNotes.class);
                fourth_category.putExtra("category", "Несрочные и неважные дела");
                startActivity(fourth_category);
                break;
        }
    }
}
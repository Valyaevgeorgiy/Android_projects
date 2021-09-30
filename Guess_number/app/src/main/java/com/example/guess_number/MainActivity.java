package com.example.guess_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    int random_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generate_random_number(100);
    }

    public void onClick(View v){
        EditText etInput = findViewById(R.id.editTextNumber);
        TextView mainTv = findViewById(R.id.textView);
        if (etInput.getText().length() == 0){
            mainTv.setText(getResources().getString(R.string.error));
        }
        else {
            int player_guess = Integer.parseInt(etInput.getText().toString());
            if (0 <= player_guess && 100 >= player_guess) {
                if (player_guess > random_number) {
                    mainTv.setText(getResources().getString(R.string.ahead));
                }
                if (player_guess < random_number) {
                    mainTv.setText(getResources().getString(R.string.behind));
                }
                if (player_guess == random_number) {
                    mainTv.setText(getResources().getString(R.string.hit));
                    generate_random_number(100);
                }
            }
            else {
                mainTv.setText(getResources().getString(R.string.num_error));
            }
        }
    }

    public void generate_random_number(int max) {
        int random_int = (int) (Math.random() * ++max);
        Log.d("Random", "Random number is: " + random_int);
        random_number = random_int;
    }

    public void destroyApp(View v) {
        finish();
    }
}


package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainText;
        Button mainBtn;

        mainText = (TextView) findViewById(R.id.mainTxt);
        mainBtn = (Button) findViewById(R.id.main_btn);
        ImageView increase_image = findViewById(R.id.plus_image);
        ImageView decrease_image = findViewById(R.id.minus_image);

        increase_image.setOnClickListener(increaseListener);
        decrease_image.setOnClickListener(decreaseListener);
        mainBtn.setOnClickListener(clickListener);
    }

    public String getScoreAddition(int num) {
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "раз";
        }
        switch (num % 10) {
            case 2:
            case 3:
            case 4:
                return "раза";
            default:
                return "раз";
        }
    }

    View.OnClickListener increaseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            String count = (String) (getScoreAddition((int) score));
            Log.d("Clicks", "Кнопка нажата: " + score + " " + count);
            score ++;
            TextView mainText = findViewById(R.id.mainTxt);
            String count_two = (String) (getScoreAddition((int) score));
            String s = "Кнопка нажата: " + score + " " + count_two;
            mainText.setText(s.toCharArray(), 0, s.length());
        }
    };

    View.OnClickListener decreaseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            String count = (String) (getScoreAddition((int) score));
            Log.d("Clicks", "Кнопка нажата: " + score + " " + count);
            score --;
            TextView mainText = findViewById(R.id.mainTxt);
            String count_two = (String) (getScoreAddition((int) score));
            String s = "Кнопка нажата: " + score + " " + count_two;
            mainText.setText(s.toCharArray(), 0, s.length());
        }
    };

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String count = (String) (getScoreAddition((int) score));
            Log.d("Clicks", "Кнопка нажата: " + score + " " + count);
            score = 0;
            TextView mainText = findViewById(R.id.mainTxt);
            String count_two = (String) (getScoreAddition((int) score));
            String s = "Кнопка нажата: " + score + " " + count_two;
            mainText.setText(s.toCharArray(), 0, s.length());
        }
    };
}
package com.example.health_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class Results extends MainActivity {

    TextView ResultDescription;
    TextView MetricsDescription;
    ImageView Metrics_1;
    ImageView Metrics_2;
    String[] credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ResultDescription = findViewById(R.id.result_description);
        MetricsDescription = findViewById(R.id.metrics_description);

        Metrics_1 = findViewById(R.id.metrics_tv);
        Metrics_2 = findViewById(R.id.metrics_tv_smile);

        Intent intent = getIntent();

        int final_difference = intent.getIntExtra("final_difference", 0);
        int pulse_lie = intent.getIntExtra("pulse_lie", 0);
        int pulse_stand = intent.getIntExtra("pulse_stand", 0);

        credentials = intent.getStringArrayExtra("credentials");

        Log.d("Difference", "Final difference is: " + final_difference);
        Log.d("User credential", "day; month; year; gender " + Arrays.toString(credentials));

        if (pulse_lie < 140 && pulse_stand < 160) {
            if (final_difference >= 0 && final_difference < 13) {
                resultAwesome();
            } else if (final_difference > 12 && final_difference < 19) {
                resultGood();
            } else if (final_difference > 18 && final_difference < 26) {
                resultBad();
            } else if (final_difference > 25) {
                resultWorst();
            }
        } else { // проверяем ситуацию, когда пульс слишком высокий
            resultHospital();
        }
    }

    public void resultAwesome() {
        ResultDescription.setText("Обязательно не забывайте о регулярном профессиональном медосмотре!");
        MetricsDescription.setText("Введённые значения соответствуют полному отсутствию переутомления.");
        Metrics_1.setImageResource(R.drawable.pers_100);
        Metrics_2.setImageResource(R.drawable.awesome_condition);
    }

    public void resultGood() {
        ResultDescription.setText("Сейчас Вам необходимо отдохнуть и проконсультироваться со специалистом, если состояние не станет лучше!");
        MetricsDescription.setText("Введённые значения соответствуют умеренному уровню переутомления.");
        Metrics_1.setImageResource(R.drawable.pers_60);
        Metrics_2.setImageResource(R.drawable.good_condition);
    }

    public void resultBad() {
        ResultDescription.setText("Вам просто небходимо сейчас срочно отдохнуть и обратиться в медицинское учреждение для осмотра!");
        MetricsDescription.setText("Введённые значения соответствуют сильному уровню переутомления.");
        Metrics_1.setImageResource(R.drawable.pers_40);
        Metrics_2.setImageResource(R.drawable.bad_condition);
    }

    public void resultWorst() {
        ResultDescription.setText("Сейчас срочно Вам необходима госпитализация и больничный режим! У вас критическое переутомление!");
        MetricsDescription.setText("Введённые значения соответствуют критическому уровню переутомления.");
        Metrics_1.setImageResource(R.drawable.pers_0);
        Metrics_2.setImageResource(R.drawable.worst_condition);
    }

    public void resultHospital() {
        ResultDescription.setText("У вас слишком высокий пульс!");
        MetricsDescription.setText("Введённые значения соответствуют критическому показателю пульса.");
        Metrics_1.setImageResource(R.drawable.pers_0);
        Metrics_2.setImageResource(R.drawable.worst_condition);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.results_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.setGroupVisible(R.id.ex_menu, false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_new_test) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
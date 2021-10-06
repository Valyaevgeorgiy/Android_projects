package com.example.main_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // элементы экрана
    TextView tv;
    CheckBox chb, chb_sec;

    /** Called when the activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // находим элементы
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
        chb_sec = (CheckBox) findViewById(R.id.chbOtherMenu);
    };

    // создание меню
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    };

    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит нажатая галочка
        menu.setGroupVisible(R.id.group1, chb.isChecked());
        menu.setGroupVisible(R.id.group2, chb_sec.isChecked());
        return super.onPrepareOptionsMenu(menu);
    };

    // обработчик нажатий пользователем пунктов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();

        // выведем в TextView информацию о нажатом пунтке меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        tv.setText(sb.toString());

        // если выбран пункт выхода в меню
        if (item.getItemId() == R.id.menu_exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
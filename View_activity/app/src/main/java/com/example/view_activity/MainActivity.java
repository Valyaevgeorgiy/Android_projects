package com.example.view_activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    TextView mainTextView;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter<String> mArrayAdapter;
    ArrayList<String> mNameList = new ArrayList<>();

    Button mainButton, append_btn, reset_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.main_textview);
        mainButton = findViewById(R.id.main_button);
        mainEditText = findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);

        append_btn = findViewById(R.id.append_btn);
        reset_btn = findViewById(R.id.reset_btn);

        mainListView.setOnItemClickListener(arrayListener);
        mainButton.setOnClickListener(oclbtn);
        append_btn.setOnClickListener(oclbtn);
        reset_btn.setOnClickListener(oclbtn);

        mArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
    }

    AdapterView.OnItemClickListener arrayListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Log.d("omg android", position + ": " + mNameList.get(position));
            String value = "Значение: " + mNameList.get(position).toString()
                    + " удалено из списка";
            mainTextView.setText(value);

            // Проработка удаления выделенных элементов списка
            mNameList.remove(position);
            mArrayAdapter.notifyDataSetChanged();
        }
    };

    View.OnClickListener oclbtn = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case (R.id.main_button):
                    String greeting = mainEditText.getText().toString() + " is learning Android development";
                    mainTextView.setText(greeting);
                    Toast.makeText(getApplicationContext(), "Нажата кнопка Update tv",
                            Toast.LENGTH_LONG).show();
                    break;

                case (R.id.reset_btn):
                    // Реализация кнопки Cancel
                    mainTextView.setText("Список очищен");
                    Toast.makeText(getApplicationContext(), "Нажата кнопка CLEAR",
                            Toast.LENGTH_LONG).show();
                    mNameList.clear();
                    mArrayAdapter.notifyDataSetChanged();
                    break;

                case (R.id.append_btn):
                    // Реализация кнопки Append
                    Toast.makeText(getApplicationContext(), "Нажата кнопка APPEND",
                            Toast.LENGTH_LONG).show();
                    String text_value = mainEditText.getText().toString();

                    // Условие дополнения к списку нового элемента
                    boolean is_possible = true;
                    if (mNameList.size() > 0) {
                        // Теперь проходим в цикле все элементы списка и проверяем, есть ли совпадение
                        for (int i=0; i < mNameList.size(); i++) {
                            if (text_value.equals(mNameList.get(i))) {
                                Log.e("Unique", "value: " + mNameList.get(i) + " already in array");
                                // Если нашли повторяющееся значение - прорабатываем по логике невозможность создания
                                is_possible = false;
                            }
                        }
                        // Если не встретили повторяющееся значение - добавляем новые элементы и сортируем список
                        if (is_possible) {
                            String value = "Значение: " +
                                    text_value + " добавлено в список.";
                            mainTextView.setText(value);
                            mNameList.add(text_value);
                            // Начинаем сортировку значений в списке по алфавиту
                            mNameList.sort(Comparator.naturalOrder());
                            mArrayAdapter.notifyDataSetChanged();
                        } else {
                            String value = "Значение: " +
                                    text_value + " уже существует в списке!";
                            mainTextView.setText(value);
                        }
                        // Только добавляем первый элемент в список
                    } else {
                        mNameList.add(text_value);
                        mArrayAdapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };
}


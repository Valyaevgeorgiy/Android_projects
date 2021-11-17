package com.example.filter_intent_additional_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = findViewById(R.id.etLink);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btnBrowser):
                Uri address = Uri.parse("https://" + etLink.getText().toString());
                Intent openBrowser = new Intent(Intent.ACTION_VIEW, address);
                startActivity(openBrowser);
                break;
            case (R.id.btnAction):
                Intent systemAction = new Intent(this, Action_systemActivity.class);
                startActivity(systemAction);
                break;
            case (R.id.btnEditor):
                Intent textEditor = new Intent(this, EditorActivity.class);
                startActivity(textEditor);
                break;
            case (R.id.btnCamera):
                Intent cameraActivity = new Intent(this, Camera_showActivity.class);
                startActivity(cameraActivity);
                break;
        }
    }
}
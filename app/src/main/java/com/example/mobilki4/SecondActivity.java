package com.example.mobilki4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewSurname = findViewById(R.id.textViewSurname);
        EditText editTextSubject = findViewById(R.id.editTextSubject);
        Button buttonEnterInfo = findViewById(R.id.buttonEnterInfo);

        textViewName.setText(getIntent().getStringExtra("NAME"));
        textViewSurname.setText(getIntent().getStringExtra("SURNAME"));

        buttonEnterInfo.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String scheduleInfo = data.getStringExtra("SCHEDULE_INFO");
            Toast.makeText(this, "Время занятия успешно передано: " + scheduleInfo, Toast.LENGTH_LONG).show();
        }
    }
}

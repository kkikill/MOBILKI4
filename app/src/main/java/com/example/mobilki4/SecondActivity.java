package com.example.mobilki4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText subjectInput;
    private String name, surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameText = findViewById(R.id.nameText);
        TextView surnameText = findViewById(R.id.surnameText);
        subjectInput = findViewById(R.id.subjectInput);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        surname = intent.getStringExtra("surname");

        nameText.setText("Имя: " + name);
        surnameText.setText("Фамилия: " + surname);
    }

    public void openThirdActivity(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String schedule = data.getStringExtra("schedule");
            subjectInput.setText(schedule);
        }
    }
}

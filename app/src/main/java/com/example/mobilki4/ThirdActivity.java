package com.example.mobilki4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private EditText dayInput, timeInput, commentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        dayInput = findViewById(R.id.dayInput);
        timeInput = findViewById(R.id.timeInput);
        commentInput = findViewById(R.id.commentInput);
    }

    public void returnToSecondActivity(View view) {
        String schedule = "День: " + dayInput.getText().toString() +
                ", Время: " + timeInput.getText().toString() +
                ", Комментарий: " + commentInput.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("schedule", schedule);
        setResult(RESULT_OK, resultIntent);
        Toast.makeText(this, "Время занятия успешно передано!", Toast.LENGTH_SHORT).show();
        finish();
    }
}

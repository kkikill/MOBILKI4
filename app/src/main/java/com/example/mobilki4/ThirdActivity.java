package com.example.mobilki4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        EditText editTextDay = findViewById(R.id.editTextDay);
        EditText editTextTime = findViewById(R.id.editTextTime);
        EditText editTextComments = findViewById(R.id.editTextComments);
        Button buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(v -> {
            String scheduleInfo = editTextDay.getText().toString() + " - " +
                    editTextTime.getText().toString() + ", " +
                    editTextComments.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("SCHEDULE_INFO", scheduleInfo);
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}

package com.raoshashwat.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    TextView display;
    String name;
    EditText enter;
    String[] arguments;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);
        display = findViewById(R.id.name_display);
        enter = findViewById(R.id.name_enter);
        arguments = getResources().getStringArray(R.array.args);
        name = "";
        display.setText(arguments[count]);
    }

    public void submit(View view) {
        name = String.valueOf(enter.getText());
        
    }

    public void increment(View view) {
        if(++count >= arguments.length) count = 0;
        display.setText(arguments[count % arguments.length]);
    }


    public void decrement(View view) {
        if(--count < 0) count = arguments.length - 1;
        display.setText(arguments[count % arguments.length]);
    }
}
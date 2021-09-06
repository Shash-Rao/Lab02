package com.raoshashwat.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    TextView nameDisplay;
    TextView cycleDisplay;
    ImageView imageDisplay;
    String name;
    EditText enter;
    String[] arguments;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.submit_button);
        nameDisplay = findViewById(R.id.name_display);
        cycleDisplay = findViewById(R.id.cycle_display);
        imageDisplay = findViewById(R.id.image_display);
        enter = findViewById(R.id.name_enter);
        arguments = getResources().getStringArray(R.array.args);
        name = "";
        cycleDisplay.setText(arguments[count]);
    }

    public void submit(View view) {
        name = String.valueOf(enter.getText());
        nameDisplay.setText(name);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void increment(View view) {
        if(++count >= arguments.length) count = 0;
        cycleDisplay.setText(arguments[count % arguments.length]);
        String drawableName = arguments[count].toLowerCase();
        int resId = getResources().getIdentifier(drawableName , "drawable", getPackageName());
        imageDisplay.setImageResource(resId);
    }


    public void decrement(View view) {
        if(--count < 0) count = arguments.length - 1;
        cycleDisplay.setText(arguments[count % arguments.length]);
        String drawableName = arguments[count].toLowerCase();
        int resId = getResources().getIdentifier(drawableName , "drawable", getPackageName());
        imageDisplay.setImageResource(resId);
    }
}
package com.example.wordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class quiz extends AppCompatActivity {
TextView quiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
         quiz=(TextView) findViewById(R.id.textView2);
        Intent j=getIntent();

    }
}

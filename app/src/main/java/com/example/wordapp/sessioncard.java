package com.example.wordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

public class sessioncard extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessioncard);

        t1=(TextView) findViewById(R.id.textView2);
        Intent j=getIntent();

    }
}

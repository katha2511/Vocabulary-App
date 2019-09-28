package com.example.wordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Binder;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Button btn,btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            btn =(Button) findViewById(R.id.btn1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i= new Intent(MainActivity.this, Session.class);
                    startActivity(i);
                }
            });
            btn1=(Button) findViewById(R.id.btn2);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent j=new Intent(MainActivity.this,revision.class);
                    startActivity(j);
                }
            });

        btn2=(Button) findViewById(R.id.btn3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MainActivity.this,quiz.class);
                startActivity(j);
            }
        });

        btn3=(Button) findViewById(R.id.btn4);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MainActivity.this,book_pdf.class);
                startActivity(j);
            }
        });
    }
}

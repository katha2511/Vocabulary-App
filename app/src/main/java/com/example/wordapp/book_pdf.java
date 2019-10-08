package com.example.wordapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class book_pdf extends AppCompatActivity {

    private PDFView pdfBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent j=getIntent();
        setContentView(R.layout.activity_book_pdf);
        pdfBook=(PDFView)findViewById(R.id.pdfBook);

        pdfBook.fromAsset("Word power made easy book.pdf").load();

    }
}

package com.example.wordapp;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.*;


import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
//mport android.content.Intent;

public class Session extends AppCompatActivity {
  GridView gridView;
    //ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;

   // View view;

 String[] valuelist={"1","2","3","4","5","6","7","8","9","10"

  };

  int[] imagelist={
          R.drawable.img1,
          R.drawable.img2,
          R.drawable.img3,
          R.drawable.img4,
          R.drawable.img5,
          R.drawable.img6,
          R.drawable.img7,
          R.drawable.img8,
          R.drawable.img9,
          R.drawable.img10

  };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);


        gridView=(GridView)findViewById(R.id.gridview);
        Intent i=getIntent();
        Gridadapter gridadapter=new Gridadapter(Session.this,imagelist,valuelist);
        gridView.setAdapter(gridadapter);


      gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent j= new Intent(Session.this, sessioncard.class);
              startActivity(j);
              Toast.makeText(Session.this,"clicked icon"+valuelist[position],Toast.LENGTH_SHORT).show();
          }


      });
    }
}




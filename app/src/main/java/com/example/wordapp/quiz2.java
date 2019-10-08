package com.example.wordapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class quiz2 extends AppCompatActivity {
 private static final int REQUEST_CODE_QUIZ=1;

 public static final String SHARED_PREFS="sharedprefs";
 public static final String KEY_HIGHSCORE="keyhighscore";

 private TextView textViewhighscore;
 private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        textViewhighscore=findViewById(R.id.highscore);
        loadHighscore();

        Button button=findViewById(R.id.button_start_quiz);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuiz();
            }
        });
    }

    private  void startQuiz(){
        Intent i=new Intent(quiz2.this,quiz.class);
        startActivityForResult(i,REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_QUIZ){
            if(resultCode == RESULT_OK){
                int score=data.getIntExtra(quiz.EXTRA_SCORE,0);
                if(score > highScore){
                    updateHighscore(score);
                }
            }
        }
    }

private void loadHighscore(){
    SharedPreferences prefs= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
    highScore=prefs.getInt(KEY_HIGHSCORE,0);
    textViewhighscore.setText("HIGHSCORE: "+highScore);



}


    private void updateHighscore(int highScoreNew){
        highScore= highScoreNew;
        textViewhighscore.setText("HIGHSCORE: "+highScore);
        SharedPreferences prefs= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt(KEY_HIGHSCORE,highScore);
        editor.apply();
    }
}

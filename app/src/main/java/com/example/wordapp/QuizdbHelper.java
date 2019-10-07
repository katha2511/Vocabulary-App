package com.example.wordapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.wordapp.quizcontract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizdbHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME="Quiz.db";
    private static int DATABASE_VERSION=1;

    private SQLiteDatabase db;


    public QuizdbHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             this.db=db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";

             db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
             fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionsTable(){
        question q1=new question("A is correct","A","B","c",1);
        addQuestion(q1);
        question q2=new question("B is correct","A","B","c",2);
        addQuestion(q2);
        question q3=new question("C is correct","A","B","c",3);
        addQuestion(q3);
        question q4=new question("A is correct again","A","B","c",1);
        addQuestion(q4);
        question q5=new question("B is correct again","A","B","c",2);
        addQuestion(q5);
    }
    private void addQuestion(question que){
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION,que.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,que.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,que.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,que.getOption3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR,que.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

    public List<question> getAllQuestions(){
        List<question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c=db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME,null);

        if(c.moveToFirst()){
            do{
                question que=new question();
                que.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                que.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                que.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                que.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                que.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(que);

            }while (c.moveToNext());
        }
        c.close();
        return questionList;

    }
}

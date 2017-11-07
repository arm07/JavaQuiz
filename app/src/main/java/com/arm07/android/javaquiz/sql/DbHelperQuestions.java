package com.arm07.android.javaquiz.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.arm07.android.javaquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashmi on 11/6/2017.
 */

// DBHelper  class to add quiz questions to SQLite DB

public class DbHelperQuestions extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD="optd"; //option d
    private SQLiteDatabase dbase;

    private String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
            + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
            +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";

    private String DROP_USER_TABLE="DROP TABLE IF EXISTS " + TABLE_QUEST;

    public DbHelperQuestions(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL(DROP_USER_TABLE);
        // Create tables again
        onCreate(db);
    }

    private void addQuestions()
    {
        Question q1=new Question(1,"How to pass the data between activities in Android?","Intent","Content Provider","Broadcast receiver","None of the Above","Intent","An Intent is used to connect one activity to another activity and having a message passing mechanism between activities.");
        this.addQuestion(q1);
        Question q2=new Question(2,"How many sizes are supported by Android?","Android supported all sizes","Android does not support all sizes","Android supports small,normal, large and extra-large sizes","Size is undefined in android","ndroid supports small,normal, large and extra-large sizes","X-large screens are having at least 960dp*720dp resolutions\n" +
                "\n" +
                "Large screens are having at least 640dp*480dp resolutions\n" +
                "\n" +
                "Normal screens are having at least 470dp*320dp resolutions\n" +
                "\n" +
                "Small screens are having at least 426dp*320dp resolutions");
        this.addQuestion(q2);
        Question q3=new Question(3,"What is broadcast receiver in android?","It will react on broadcast announcements.","It will do background functionalities as services.","It will pass the data between activities.","None of the Above","It will react on broadcast announcements.","It is a main component of android. It reacts on the system broadcast announcements, and it acts as a gateway between outside application environment with your application.");
        this.addQuestion(q3);
        Question q4=new Question(4,"How to store heavy structured data in android?","Shared Preferences","Cursor","SQlite database","Not possible","SQlite database","We can store structured data in SQlite database only. SQlite database is very efficient and faster to read and store the data.");
        this.addQuestion(q4);
        Question q5=new Question(5,"How to get current location in android?","Using with GPRS","Using location provider","A & B","Network servers","A & B","GPRS and Location provider is used to fetch the current location of a phone as longitude and latitude.");
        this.addQuestion(q5);
        Question q6=new Question(6,"What is DDMS in android?","Dalvik memory server","Device memory server","Dalvik monitoring services","Dalvik debug monitor services","Dalvik debug monitor services","DDMS provides port forwarding, screen capturing, memory mapping, logcat, calls, SMS etc.");
        this.addQuestion(q6);
        Question q7=new Question(7,"What are the functionalities of HTTP Client interface in android?","Connection management","Cookies management","Authentication management","All of the above","All of the above","HTTP Client has the capabilities to manage connections, cookies and Authentication.");
        this.addQuestion(q7);
        Question q8=new Question(8,"How many orientations does android support?","4","10","2","None of the Above","4","According to the Google documentation, Android supports 4 types of orientations, those are landscape, portrait, sensor and No orientation");
        this.addQuestion(q8);
        Question q9=new Question(9,"How many protection levels are available in the android permission tag?","There are no permission tags available in android","Normal, kernel, application","Normal, dangerous, signature, and signatureOrsystem","None of the Above","Normal, dangerous, signature, and signatureOrsystem","Android is having four levels of protection in android permission tag. They are normal, dangerous, signature, and signatureOrsystem");
        this.addQuestion(q9);
        Question q10=new Question(10,"What is anchor view?","Same as list view","provides the information on respective relative positions","Same as relative layout","None of the Above","provides the information on respective relative positions","Anchor View provides the information on respective relative positions of views.");
        this.addQuestion(q10);

    }

    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getCorrectAnswer());
        values.put(KEY_OPTA, quest.getOptions1());
        values.put(KEY_OPTB, quest.getOptions2());
        values.put(KEY_OPTC, quest.getOptions3());
        values.put(KEY_OPTD,quest.getOptions4());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setQuestionId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setCorrectAnswer(cursor.getString(2));
                quest.setOptions1(cursor.getString(3));
                quest.setOptions2(cursor.getString(4));
                quest.setOptions3(cursor.getString(5));
                quest.setOptions4(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
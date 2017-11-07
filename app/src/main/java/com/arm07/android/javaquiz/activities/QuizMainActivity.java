package com.arm07.android.javaquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.arm07.android.javaquiz.R;
import com.arm07.android.javaquiz.model.Question;
import com.arm07.android.javaquiz.sql.DbHelperQuestions;

import java.util.List;

public class QuizMainActivity extends AppCompatActivity {

    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc,rdd;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHelperQuestions db=new DbHelperQuestions(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton) findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getCorrectAnswer()+" "+answer.getText());
                if(currentQ.getCorrectAnswer().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                if(qid<9){
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }else{
                    Intent intent = new Intent(QuizMainActivity.this, ResultActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("score", score); //Your score
                    intent.putExtras(b); //Put your score to your next Intent
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQuestion());
        rda.setText(currentQ.getOptions1());
        rdb.setText(currentQ.getOptions2());
        rdc.setText(currentQ.getOptions3());
        rdd.setText(currentQ.getOptions4());
        qid++;
    }
}

package com.arm07.android.javaquiz.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

import com.arm07.android.javaquiz.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 1:
            case 2: t.setText("Opps, try again bro, keep learning");
                break;
            case 3:
            case 4:t.setText("It seems you have been reading a lot of Android Programmer quiz");
                break;
            case 5:t.setText("Who are you? A student in Android Programming???");
                break;
        }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }*/
}

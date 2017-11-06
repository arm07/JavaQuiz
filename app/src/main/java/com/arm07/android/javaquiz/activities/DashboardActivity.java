package com.arm07.android.javaquiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arm07.android.javaquiz.R;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStart,btnStrtAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnStart = (Button)findViewById(R.id.btnStartJava);
        btnStrtAndroid = (Button)findViewById(R.id.btnStrtAndroid);

        btnStart.setOnClickListener(this);
        btnStrtAndroid.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnStrtAndroid:
                final Intent intentMain = new Intent(this,QuizMainActivity.class);
                startActivity(intentMain);

                /*AlertDialog.Builder b = new AlertDialog.Builder(QuizDeskBoardActivity.this)
                        .setTitle("Start Quiz")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                startActivity(intentMain);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.cancel();
                            }
                        })
                        .setMessage("All the Best!!!");
                b.create().show();*/

                break;

            case R.id.btnStartJava:

                /*Intent intentInstruction = new Intent(this,QuizInstructionActivity.class);
                startActivity(intentInstruction);*/
                break;
        }


    }
}

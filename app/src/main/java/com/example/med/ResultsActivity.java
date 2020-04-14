package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        getSupportActionBar().setTitle("ТЕСТ ОКОНЧЕН");

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mFinalScore.setText("You scored " + score + " out of " + QuestionLibrary.questions.length);

        if (score == 20 ){
            mGrade.setText("Outstanding");
        }else if (score == 19){
            mGrade.setText("Outstanding");}
        else if (score == 18){
            mGrade.setText("Outstanding");}
        else if (score == 17){
            mGrade.setText("Good Work");}
        else if (score == 16){
            mGrade.setText("Good Work");
        }else if (score == 15) {
            mGrade.setText("Good Effort");
        }else {
            mGrade.setText("Go over your notes");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, TestActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
    }


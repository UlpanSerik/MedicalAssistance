package com.example.med;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private TextView mScoreView, mQuestion;
    private ImageView mImageView;
    private Button mTrueButton, mFalseButton;

    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().setTitle("ТЕСТ НА ПРОВЕРКУ ЗНАНИЙ");
        mScoreView = (TextView)findViewById(R.id.points);
        mImageView = (ImageView)findViewById(R.id.imageView);
        mQuestion = (TextView)findViewById(R.id.question);
        mTrueButton = (Button)findViewById(R.id.trueButton);
        mFalseButton = (Button)findViewById(R.id.falseButton);

        updateQuestion();

        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == true) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuestionLibrary.questions.length) {
                        Intent i = new Intent(TestActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        TestActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuestionLibrary.questions.length) {
                        Intent i = new Intent(TestActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        TestActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });




        //Logic for false button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswer == false) {
                    mScore++;
                    updateScore(mScore);

                    //perform check before you update the question
                    if (mQuestionNumber == QuestionLibrary.questions.length) {
                        Intent i = new Intent(TestActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        TestActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionNumber == QuestionLibrary.questions.length) {
                        Intent i = new Intent(TestActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        TestActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

    }

    private void updateQuestion() {

        mImageView.setImageResource(QuestionLibrary.images[mQuestionNumber]);
        mQuestion.setText(QuestionLibrary.questions[mQuestionNumber]);
        mAnswer = QuestionLibrary.answers[mQuestionNumber];
        mQuestionNumber++;
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setMessage("Закончить?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    }



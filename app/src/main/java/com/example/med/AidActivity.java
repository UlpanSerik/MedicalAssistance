package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aid);

        getSupportActionBar().setTitle("ОКАЗАНИЕ ПЕРВОЙ ПОМОЩИ");

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);
        Button btn10 = findViewById(R.id.btn10);
        Button btn11 = findViewById(R.id.btn11);
        Button btn12 = findViewById(R.id.btn12);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(AidActivity.this, Activity1.class);
                startActivity(i1);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(AidActivity.this, Activity2.class);
                startActivity(i2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(AidActivity.this, Activity3.class);
                startActivity(i3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(AidActivity.this, Activity4.class);
                startActivity(i4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(AidActivity.this, Activity5.class);
                startActivity(i5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6 = new Intent(AidActivity.this, Activity6.class);
                startActivity(i6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7 = new Intent(AidActivity.this, Activity7.class);
                startActivity(i7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i8 = new Intent(AidActivity.this, Activity8.class);
                startActivity(i8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i9 = new Intent(AidActivity.this, Activity9.class);
                startActivity(i9);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i10 = new Intent(AidActivity.this, Activity10.class);
                startActivity(i10);
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i11 = new Intent(AidActivity.this, Activity11.class);
                startActivity(i11);
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i12 = new Intent(AidActivity.this, Activity12.class);
                startActivity(i12);
            }
        });
    }
}

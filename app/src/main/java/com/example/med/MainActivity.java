package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(MainActivity.this, AidActivity.class);
                startActivity(int2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(MainActivity.this, CovidActivity.class);
                startActivity(int3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(MainActivity.this, MaskActivity.class);
                startActivity(int4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5 = new Intent(MainActivity.this, TestActivity.class);
                startActivity(int5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int6 = new Intent(MainActivity.this, MedicineActivity.class);
                startActivity(int6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int7 = new Intent(MainActivity.this, DustActivity.class);
                startActivity(int7);
            }
        });
    }
    //Emergency Call
    public void button1(View v) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:103"));
        startActivity(i);
    }

}

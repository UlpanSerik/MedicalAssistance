package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class DustActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dust);
        getSupportActionBar().setTitle("ЗАГРЯЗНЕНИЕ ВОЗДУХА");

    }

    public void open(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iqair.com/ru/kazakhstan"));
        startActivity(intent);
    }
}

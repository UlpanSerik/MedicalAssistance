package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import android.view.View;

public class CovidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        getSupportActionBar().setTitle("COVID-19");

        VideoView videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.covid;
        videoView.setVideoPath(videoPath);
        videoView.start();
    }

    public void open(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://anti-corona.kz/#data"));
        startActivity(intent);
    }
}

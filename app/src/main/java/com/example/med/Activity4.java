package com.example.med;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        getSupportActionBar().setTitle("Приступ Астмы");
        VideoView videoView = findViewById(R.id.videoView2);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.astma;
        videoView.setVideoPath(videoPath);
        videoView.start();
    }
}

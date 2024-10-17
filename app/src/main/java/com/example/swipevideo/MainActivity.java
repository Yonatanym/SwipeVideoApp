package com.example.swipevideo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();
        VideoItem videoCelebration = new VideoItem();
        videoCelebration.videoURL = "https://firebasestorage.googleapis.com/v0/b/quiz-f51b6.appspot.com/o/AEUN6990.MP4?alt=media&token=3f119630-5725-4e6f-9e74-b5d38f9bb854";
        videoCelebration.videoTitle = "Visualization";
        videoCelebration.videoDescription = "Bob Proctor, Life advice";
        videoItemsList.add(videoCelebration);

        VideoItem videoCelebration2 = new VideoItem();
        videoCelebration2.videoURL = "https://firebasestorage.googleapis.com/v0/b/quiz-f51b6.appspot.com/o/OJLE4846.MP4?alt=media&token=e29696e3-aa82-4890-827e-0c4e6895e6b9";
        videoCelebration2.videoTitle = "Advice";
        videoCelebration2.videoDescription = "Jim Rohn, Parents Advice";
        videoItemsList.add(videoCelebration2);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}
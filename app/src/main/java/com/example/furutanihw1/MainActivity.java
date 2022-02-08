package com.example.furutanihw1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /**
         External Citation
         Date: 6 February 2022
         Problem: Wanted to play yoshi theme
         Resource:
          https://stackoverflow.com/questions/5777413/android-raw-folders-creation-and-reference
         Solution: I used the example code from this post.
         */
        mediaPlayer = MediaPlayer.create(this, R.raw.yoshitheme);
        mediaPlayer.start();


    }


}
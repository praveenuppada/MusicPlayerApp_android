package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        music = MediaPlayer.create(this, R.raw.joutre);
    }

    public void musicPlay(View v) {
        if (music != null && !music.isPlaying()) {
            music.start();
        }
    }

    public void musicPause(View v) {
        if (music != null && music.isPlaying()) {
            music.pause();
        }
    }

    public void musicStop(View v) {
        if (music != null) {
            music.stop();
            music.reset();
            music = MediaPlayer.create(this, R.raw.joutre);
        }
    }

    @Override
    protected void onDestroy() {
        if (music != null) {
            music.release();
            music = null;
        }
        super.onDestroy();
    }
}
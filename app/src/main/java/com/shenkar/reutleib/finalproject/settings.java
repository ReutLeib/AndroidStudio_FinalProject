package com.shenkar.reutleib.finalproject;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class settings extends AppCompatActivity {

    private SeekBar volumeBar;
    public MediaPlayer backgroundSound;
    Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backgroundSound = MediaPlayer.create(this, R.raw.music_zapsplat_ultimatum);
        backgroundSound.setLooping(true);
        backgroundSound.setVolume(0.5f, 0.5f);
        backgroundSound.seekTo(0);
        backgroundSound.start();

        playBtn = findViewById(R.id.playmusic);
        volumeBar = findViewById(R.id.volumeBar);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                backgroundSound.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void clickPlayMusic(View view){
        if(!backgroundSound.isPlaying()){
            //stopping
            backgroundSound.start();
            playBtn.setBackgroundResource(R.drawable.pause);
        } else{
            // plaining
            backgroundSound.pause();
            playBtn.setBackgroundResource(R.drawable.playmusic);
        }
    }
}

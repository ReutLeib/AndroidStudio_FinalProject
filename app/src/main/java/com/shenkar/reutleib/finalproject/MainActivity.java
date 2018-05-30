package com.shenkar.reutleib.finalproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer backgroundSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundSound = MediaPlayer.create(this, R.raw.music_zapsplat_ultimatum);
        backgroundSound.setLooping(true);
        backgroundSound.start();

    }

    public void setBackgroundSound(MediaPlayer bgSound){
        this.backgroundSound = bgSound;
    }

    public MediaPlayer getBackgroundSound(){
        return backgroundSound;
    }

    public void clickSetting(android.view.View view){
        backgroundSound.pause();
        startActivity(new Intent(this, settings.class));
    }

    public void clickPlay(android.view.View view){
        backgroundSound.pause();
        startActivity(new Intent(this,start_game.class));
    }


}

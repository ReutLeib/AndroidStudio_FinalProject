package com.shenkar.reutleib.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

// its like activity animation

public class start_game extends AppCompatActivity {

    private StartGame startGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startGame = new StartGame(this);
        setContentView(startGame);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                handleClickEvent(event);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private void handleClickEvent(MotionEvent event) {
        if(startGame.menuScreen){
            startGame.menuScreen = false;
        }
//        else {
//            if(startGame.validPosition((int)event.getRawX(), (int)event.getRawY())) {
//                startGame.addBall((int)event.getRawX(), (int)event.getRawY());
//            }
//        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        startGame.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startGame.resume();
    }
}

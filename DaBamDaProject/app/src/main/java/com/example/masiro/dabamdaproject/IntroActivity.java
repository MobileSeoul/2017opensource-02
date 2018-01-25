package com.example.masiro.dabamdaproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by masiro on 2017-11-30.
 */

public class IntroActivity extends AppCompatActivity{
    Handler handler = new Handler();
    Runnable updater = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(
                    getApplicationContext(), // 현재 화면의 제어권자
                    MainActivity.class); // 다음 넘어갈 클래스 지정
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(updater, 3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(updater);
    }
}

package com.example.popkovanton.soundpool;


import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    final int MAX_STREAMS = 5;

    SoundPool sp;
    int soundIdShot;
    int soundIdExplosion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0); //создаем класс SoundPool


        soundIdShot = sp.load(this, R.raw.shot, 1);     // первый вариант загрузки из raw


        try {                                                                     //
            soundIdExplosion = sp.load(getAssets().openFd("explosion.ogg"), 1);   //
        } catch (IOException e) {                                                 //  второй вариант
            e.printStackTrace();                                                  //  загрузки из assets
        }                                                                         //
    }

    public void onClick(View view) { //запускаем воспроизведение файлов
        sp.play(soundIdShot, 1, 1, 0, 0, 0.5f);
        sp.play(soundIdExplosion, 1, 1, 0, 0, 2);
    }

}

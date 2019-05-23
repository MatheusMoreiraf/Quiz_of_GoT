package com.example.quizofgot.activity.activity.model;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.quizofgot.R;

public class Sound {
    public static MediaPlayer mp = new MediaPlayer();
    public static MediaPlayer mpTelas = new MediaPlayer();
    private static boolean comSom = true;

    public static void playAudio(Context c, int sound) {
        mp.stop();
        mp = MediaPlayer.create(c, sound);
        mp.start();
        mp.setLooping(true);
        comSom = true;
    }

    public static void stopAudio() {
        mp.stop();
        mpTelas.release();
        comSom = false;
    }

    public static void entreTelasAudio(Context c) {
        if (comSom) {
            mpTelas = MediaPlayer.create(c, R.raw.espada);
            mpTelas.start();
        }
    }

}

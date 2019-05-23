package com.example.quizofgot.activity.activity.model;

import android.content.Context;
import android.media.MediaPlayer;

public class Sound {
    public static MediaPlayer mp = new MediaPlayer();

    public static void playAudio(Context c, int sound) {
        mp.stop();
        mp = MediaPlayer.create(c, sound);
        mp.start();
        mp.setLooping(true);
    }

    public static void stopAudio() {
        mp.stop();
    }
}

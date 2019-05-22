package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quizofgot.R;

public class ConfActivity extends AppCompatActivity {

    private MediaPlayer mp = new MediaPlayer();
    private ImageView imgStatusSom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf);
        imgStatusSom = findViewById(R.id.imgStatusSom);
    }

    public void home(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }

    public void records(View v) {
        Intent intent = new Intent(this, RecordsActivity.class);
        startActivity(intent);
    }

    public void jogador(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        startActivity(intent);
    }

    public void stopAndStartSound(View v) {

        if (imgStatusSom.getTag().equals("com som")) {
            MediaPlayer mp = new MediaPlayer();
            mp.stop();
            imgStatusSom.setImageResource(R.drawable.ic_volume_off_white_30dp);
            imgStatusSom.setTag("sem som");
        } else {
//            stopPlaying();
//            mp = MediaPlayer.create(this, R.raw.got_sound);
//            mp.start();
//            mp.setLooping(true);
//            imgStatusSom.setImageResource(R.drawable.ic_volume_start_white_30dp);
//            imgStatusSom.setTag("com som");
        }
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}

package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Sound;

public class ConfActivity extends AppCompatActivity {
    private ImageView imgStatusSom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf);
        imgStatusSom = findViewById(R.id.imgStatusSom);
        if (Sound.mp.isPlaying()) {
            imgStatusSom.setImageResource(R.drawable.ic_volume_start_white_30dp);
            imgStatusSom.setTag("com som");
        }
        else {
            imgStatusSom.setImageResource(R.drawable.ic_volume_off_white_30dp);
            imgStatusSom.setTag("sem som");
        }
    }

    public void home(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }

    public void records(View v) {
        Intent intent = new Intent(this, RecordsActivity.class);
        finish();
        startActivity(intent);
    }

    public void jogador(View v) {
        Intent intent = new Intent(this, JogadorActivity.class);
        finish();
        startActivity(intent);
    }

    public void stopAndStartSound(View v) {

        if (imgStatusSom.getTag().equals("com som")) {
            Sound.stopAudio();
            imgStatusSom.setImageResource(R.drawable.ic_volume_off_white_30dp);
            imgStatusSom.setTag("sem som");
        } else {
            Sound.playAudio(this, R.raw.got_sound);
            imgStatusSom.setImageResource(R.drawable.ic_volume_start_white_30dp);
            imgStatusSom.setTag("com som");
        }
    }
}

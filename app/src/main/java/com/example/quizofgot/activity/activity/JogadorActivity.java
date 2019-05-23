package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Sound;

public class JogadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
    }

    public void home(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }

    public void confJogo(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, ConfActivity.class);
        finish();
        startActivity(intent);
    }

    public void records(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, RecordsActivity.class);
        finish();
        startActivity(intent);
    }
}

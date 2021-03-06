package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Sound;

public class TemasActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_DESCRIPTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
    }


    public void casaSelecionada(View view) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, DescriptionActivity.class);
        Bundle params = new Bundle();
        params.putString("Casa", String.valueOf(view.getContentDescription()));
        intent.putExtras(params);
        startActivityForResult(intent, CONSTANTE_TELA_DESCRIPTION);
    }

    public void confJogo(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, ConfActivity.class);
        startActivity(intent);
    }

    public void records(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, RecordsActivity.class);
        startActivity(intent);
    }

    public void jogador(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, JogadorActivity.class);
        startActivity(intent);
    }

}

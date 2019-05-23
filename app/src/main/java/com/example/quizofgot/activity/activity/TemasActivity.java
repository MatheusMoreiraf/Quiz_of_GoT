package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quizofgot.R;

public class TemasActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_DESCRIPTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
    }


    public void casaSelecionada(View view) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        Bundle params = new Bundle();
        params.putString("Casa", String.valueOf(view.getContentDescription()));
        intent.putExtras(params);
        fileList();
        startActivityForResult(intent, CONSTANTE_TELA_DESCRIPTION);
    }

    public void confJogo(View v) {
        Intent intent = new Intent(this, ConfActivity.class);
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

}

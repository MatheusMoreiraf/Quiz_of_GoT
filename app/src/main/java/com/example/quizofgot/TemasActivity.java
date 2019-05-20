package com.example.quizofgot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

        startActivityForResult(intent, CONSTANTE_TELA_DESCRIPTION);
    }

}
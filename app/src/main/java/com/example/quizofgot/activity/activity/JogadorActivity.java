package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.quizofgot.R;

public class JogadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
    }

    public void home(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
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
}

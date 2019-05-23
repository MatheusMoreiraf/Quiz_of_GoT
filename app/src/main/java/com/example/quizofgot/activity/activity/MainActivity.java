package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Sound;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS ranks(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR, " +
                    "pontuacao INT(2)" +
                    ")");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sound.playAudio(this, R.raw.got_sound);
    }

    public void btnJogar(View view) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, TemasActivity.class);
        startActivity(intent);
    }
}

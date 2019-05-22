package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quizofgot.R;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor cursor = null;

        try {
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
//            db.execSQL("DROP TABLE ranks");
            db.execSQL("CREATE TABLE IF NOT EXISTS ranks(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nome VARCHAR, " +
                    "pontuacao INT(2)" +
                    ")");
//            db.execSQL("INSERT INTO ranks(nome, pontuacao) VALUES('matheus', 15)");
            cursor = db.rawQuery("SELECT * FROM ranks", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mp.stop();
        mp = MediaPlayer.create(this, R.raw.got_sound);
        mp.start();
        mp.setLooping(true);
    }

    public void btnJogar(View view) {
        Intent intent = new Intent(this, TemasActivity.class);
        startActivity(intent);
    }
}

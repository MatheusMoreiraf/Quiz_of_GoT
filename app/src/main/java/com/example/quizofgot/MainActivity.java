package com.example.quizofgot;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
//            db.execSQL("DROP TABLE ranks");
            db.execSQL("CREATE TABLE IF NOT EXISTS ranks(" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "nome VARCHAR, " +
                    "pontuacao INT(2)" +
                    ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnJogar(View view) {
        Intent intent = new Intent(this, TemasActivity.class);
        startActivity(intent);
    }
}

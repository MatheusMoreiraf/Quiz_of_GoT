package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.adapter.AdapterRecords;
import com.example.quizofgot.activity.activity.model.Record;
import com.example.quizofgot.activity.activity.model.Sound;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity {

    private RecyclerView rvRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        rvRecords = findViewById(R.id.rvRecords);

        Cursor cursor = null;
        List<Record> nomePontuacao = new ArrayList<>();

        try {
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * FROM ranks ORDER BY pontuacao DESC", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int indiceNome = cursor.getColumnIndex("nome");
        int indicePontuacao = cursor.getColumnIndex("pontuacao");

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Record records = new Record(String.valueOf(cursor.getString(indiceNome)),
                        String.valueOf(cursor.getString(indicePontuacao)));
                nomePontuacao.add(records);
            } while (cursor.moveToNext());
        }

        AdapterRecords adpter = new AdapterRecords(nomePontuacao);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvRecords.setLayoutManager(layoutManager);
        rvRecords.setHasFixedSize(true);
        rvRecords.setAdapter(adpter);
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

    public void jogador(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, JogadorActivity.class);
        finish();
        startActivity(intent);
    }
}

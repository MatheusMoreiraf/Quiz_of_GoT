package com.example.quizofgot;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class RankActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Cursor cursor = null;
        String[] nomeCampos = new String[]{};

        try {
            SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * FROM ranks", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int indice_id = cursor.getColumnIndex("_id");
        int indiceNome = cursor.getColumnIndex("nome");
        int indicePontuacao = cursor.getColumnIndex("pontuacao");

        if (cursor != null && cursor.moveToFirst()) {
            do {
                nomeCampos = new String[]{
                        cursor.getString(indice_id),
                        cursor.getString(indiceNome),
                        cursor.getString(indicePontuacao)
                };
                System.out.println("Test :" + nomeCampos[0]);
                System.out.println("Test :" + cursor.getString(indiceNome));
            } while (cursor.moveToNext());
        }

        int[] idViews = new int[]{R.id.idNome, R.id.idPontuacao};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.list_pontuacoes_adapter, cursor,
                nomeCampos, idViews, 0);

        lista = findViewById(R.id.lvRank);
        lista.setAdapter(adapter);
    }


    public void home(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }

    public void confJogo(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }

    public void jogador(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }
}

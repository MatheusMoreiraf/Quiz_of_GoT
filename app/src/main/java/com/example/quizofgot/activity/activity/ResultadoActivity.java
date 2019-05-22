package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizofgot.R;

public class ResultadoActivity extends AppCompatActivity {

    TextView textTotalAcertos, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        textTotalAcertos = findViewById(R.id.textTotalAcertos);
        etNome = (TextView) findViewById(R.id.etNome);


        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                String acertos = params.getString("Acertos");
                textTotalAcertos.setText(acertos);
            }
        }
    }

    public void btnSalvar(View v) {

        System.out.println();

        String etnome = etNome.getText().toString();
        String pontuacao = textTotalAcertos.getText().toString();

        String resultado = "";

        if (!etnome.equals("")) {
            try {
                SQLiteDatabase db = openOrCreateDatabase("app", MODE_PRIVATE, null);
                db.execSQL("INSERT INTO ranks(nome,pontuacao) VALUES('" + etnome + "'," + pontuacao + ")");
                resultado = "Salvo com sucesso";
            } catch (Exception e) {
                e.printStackTrace();
                resultado = "Error ao salvar";
            }

            Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, RecordsActivity.class);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Para Salvar Coloque um nome", Toast.LENGTH_SHORT).show();
        }
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

    public void records(View v) {
        Intent intent = new Intent(this, RecordsActivity.class);
        finish();
        startActivity(intent);
    }

    public void jogador(View v) {
        Intent intent = new Intent(this, TemasActivity.class);
        finish();
        startActivity(intent);
    }
}

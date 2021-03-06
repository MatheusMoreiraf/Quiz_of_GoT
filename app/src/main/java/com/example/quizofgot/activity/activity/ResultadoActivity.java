package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Sound;

public class ResultadoActivity extends AppCompatActivity {

    TextView textTotalAcertos;
    TextInputEditText etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        textTotalAcertos = findViewById(R.id.textTotalAcertos);
        etNome = (TextInputEditText) findViewById(R.id.etNome);


        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                String acertos = params.getString("Acertos");
                textTotalAcertos.setText(acertos);
            }
        }

        etNome.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    esconderTeclado(v);
                }
            }
        });
    }

    public void btnSalvar(View v) {
        Sound.entreTelasAudio(this);

        System.out.println();

        String etnome = etNome.getText().toString();
        String pontuacao = textTotalAcertos.getText().toString();

        String resultado = "";
        esconderTeclado(v);

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

    public void esconderTeclado(View v) {
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
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

    public void records(View v) {
        Sound.entreTelasAudio(this);
        Intent intent = new Intent(this, RecordsActivity.class);
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

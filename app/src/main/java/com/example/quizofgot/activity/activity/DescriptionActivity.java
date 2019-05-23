package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quizofgot.activity.activity.util.DescricaoCasas;
import com.example.quizofgot.R;

public class DescriptionActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_QUIZ = 2;

    DescricaoCasas descricaoCasas = new DescricaoCasas();
    ImageView imageCasa;
    TextView textCasa;
    TextView textDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imageCasa = findViewById(R.id.imageCasa);
        textCasa = findViewById(R.id.textCasa);
        textDescription = findViewById(R.id.textDescription);

        confTela();
    }

    public void confTela() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                String selecionado = params.getString("Casa");
                if (selecionado.equals("Stark")) {
                    imageCasa.setImageResource(R.drawable.casa_stark);
                    textCasa.setText(selecionado);
                    textDescription.setText(descricaoCasas.casaStark);
                } else if (selecionado.equals("Lannister")) {
                    imageCasa.setImageResource(R.drawable.casa_lannister);
                    textCasa.setText(selecionado);
                    textCasa.setTextColor(Color.parseColor("#E40003"));
                    textDescription.setText(descricaoCasas.casaLannister);
                    textDescription.setTextColor(Color.parseColor("#E40003"));
                } else if (selecionado.equals("Targaryen")) {
                    imageCasa.setImageResource(R.drawable.casa_targaryon);
                    textCasa.setText(selecionado);
                    textCasa.setTextColor(Color.parseColor("#E40003"));
                    textDescription.setText(descricaoCasas.casaTargaryen);
                    textDescription.setTextColor(Color.parseColor("#E40003"));
                } else if (selecionado.equals("Greyjoy")) {
                    imageCasa.setImageResource(R.drawable.casa_grayjoy);
                    textCasa.setText(selecionado);
                    textCasa.setTextColor(Color.parseColor("#FACA36"));
                    textDescription.setText(descricaoCasas.casaGreyjoy);
                    textDescription.setTextColor(Color.parseColor("#FACA36"));
                }
            }
        }
    }

    public void comecarQuiz(View v) {
        Intent i = new Intent(this, QuizActivity.class);
        Bundle params = new Bundle();
        params.putString("Casa", String.valueOf(textCasa.getText()));
        i.putExtras(params);
        finish();
        startActivityForResult(i, CONSTANTE_TELA_QUIZ);
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

    public void jogador(View v) {
        Intent intent = new Intent(this, JogadorActivity.class);
        finish();
        startActivity(intent);
    }

}

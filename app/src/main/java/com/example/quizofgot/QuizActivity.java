package com.example.quizofgot;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    PerguntasERespostas casas = new PerguntasERespostas();
    String[][] stark = casas.casaStark;
    String[][] targaryen = casas.casaTargaryen;
    String[][] lannister = casas.casaLannister;
    String[][] greyjoy = casas.casaGreyjoy;
    Random gerador = new Random();

    String aux = "";
    String pergunta = "";
    String respostaCerta = "";
    String[] respostasErradas = new String[3];
    ArrayList<String> auxList = new ArrayList<>();
    String[] respostaTela;
    int p = 0;

    TextView textPergunta;
    Button btnA, btnB, btnC, btnD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textPergunta = findViewById(R.id.textPergunta);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        verificaCasa();
    }

    public static void embaralhar(String[] v) {
        Random random = new Random();
        for (int i = 0; i < (v.length - 1); i++) {
            //sorteia um índice
            int j = random.nextInt(v.length);
            //troca o conteúdo dos índices i e j do vetor
            String temp = v[i];
            v[i] = v[j];
            v[j] = temp;
        }
    }

    public void verificaCasa() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle params = intent.getExtras();
            if (params != null) {
                if (p == 15) {
                    Intent i = new Intent(this, ResultadoActivity.class);
                    startActivity(i);
                } else {
                    String selecionado = params.getString("Casa");
                    if (selecionado.equals("Stark")) {
                        perguntasCasaStark();
                    } else if (selecionado.equals("Lannister")) {
                        perguntasCasaLannister();
                    } else if (selecionado.equals("Targaryen")) {
                        perguntasCasaTargaryen();
                    } else if (selecionado.equals("Greyjoy")) {
                        perguntasCasaGreyjoy();
                    }
                }
            }
        }
    }

    public void perguntasCasaStark() {
        pergunta = stark[0][p];
        respostaCerta = stark[1][p];

        for (int i = 0; i < stark.length; i++) {
            auxList.add(stark[i][p]);
        }

        for (int i = 0; i < respostasErradas.length; i++) {
            int lin = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
            aux = auxList.get(lin);
            auxList.remove(auxList.get(lin));
            for (int j = 0; j < respostasErradas.length; j++) {
                if (respostasErradas[j] == aux && j != i) {
                    int a = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
                    aux = auxList.get(a);
                    auxList.remove(auxList.get(a));
                } else {
                    respostasErradas[i] = aux;
                }
            }
        }

        respostaTela = new String[]{respostasErradas[0], respostasErradas[1], respostaCerta, respostasErradas[2]};

        embaralhar(respostaTela);

        textPergunta.setText(pergunta);
        btnA.setText(respostaTela[0]);
        btnB.setText(respostaTela[1]);
        btnC.setText(respostaTela[2]);
        btnD.setText(respostaTela[3]);
    }

    public void perguntasCasaTargaryen() {
        pergunta = targaryen[0][p];
        respostaCerta = targaryen[1][p];

        for (int i = 0; i < targaryen.length; i++) {
            auxList.add(targaryen[i][p]);
        }

        for (int i = 0; i < respostasErradas.length; i++) {
            int lin = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
            aux = auxList.get(lin);
            auxList.remove(auxList.get(lin));
            for (int j = 0; j < respostasErradas.length; j++) {
                if (respostasErradas[j] == aux && j != i) {
                    int a = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
                    aux = auxList.get(a);
                    auxList.remove(auxList.get(a));
                } else {
                    respostasErradas[i] = aux;
                }
            }
        }

        respostaTela = new String[]{respostasErradas[0], respostasErradas[1], respostaCerta, respostasErradas[2]};

        embaralhar(respostaTela);

        textPergunta.setText(pergunta);
        btnA.setText(respostaTela[0]);
        btnB.setText(respostaTela[1]);
        btnC.setText(respostaTela[2]);
        btnD.setText(respostaTela[3]);
    }

    public void perguntasCasaLannister() {
        pergunta = lannister[0][p];
        respostaCerta = lannister[1][p];

        for (int i = 0; i < lannister.length; i++) {
            auxList.add(lannister[i][p]);
        }

        for (int i = 0; i < respostasErradas.length; i++) {
            int lin = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
            aux = auxList.get(lin);
            auxList.remove(auxList.get(lin));
            for (int j = 0; j < respostasErradas.length; j++) {
                if (respostasErradas[j] == aux && j != i) {
                    int a = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
                    aux = auxList.get(a);
                    auxList.remove(auxList.get(a));
                } else {
                    respostasErradas[i] = aux;
                }
            }
        }

        respostaTela = new String[]{respostasErradas[0], respostasErradas[1], respostaCerta, respostasErradas[2]};

        embaralhar(respostaTela);

        textPergunta.setText(pergunta);
        btnA.setText(respostaTela[0]);
        btnB.setText(respostaTela[1]);
        btnC.setText(respostaTela[2]);
        btnD.setText(respostaTela[3]);
    }

    public void perguntasCasaGreyjoy() {
        pergunta = greyjoy[0][p];
        respostaCerta = greyjoy[1][p];

        for (int i = 0; i < greyjoy.length; i++) {
            auxList.add(greyjoy[i][p]);
        }

        for (int i = 0; i < respostasErradas.length; i++) {
            int lin = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
            aux = auxList.get(lin);
            auxList.remove(auxList.get(lin));
            for (int j = 0; j < respostasErradas.length; j++) {
                if (respostasErradas[j] == aux && j != i) {
                    int a = gerador.nextInt(((auxList.size() - 1) - 2) + 1) + 2;
                    aux = auxList.get(a);
                    auxList.remove(auxList.get(a));
                } else {
                    respostasErradas[i] = aux;
                }
            }
        }

        respostaTela = new String[]{respostasErradas[0], respostasErradas[1], respostaCerta, respostasErradas[2]};

        embaralhar(respostaTela);

        textPergunta.setText(pergunta);
        btnA.setText(respostaTela[0]);
        btnB.setText(respostaTela[1]);
        btnC.setText(respostaTela[2]);
        btnD.setText(respostaTela[3]);
    }

    public void verificaResposta(View v) {
        final Button b = (Button) v;

        if (b.getText().toString().equals(respostaCerta)) {
            b.setBackgroundColor(Color.parseColor("#45A163"));
            b.setTextColor(Color.parseColor("#FFFFFF"));
            nextResDelay(b);
        } else {
            b.setBackgroundColor(Color.parseColor("#FD0908"));
            b.setTextColor(Color.parseColor("#FFFFFF"));
            if (btnA.getText().toString().equals(respostaCerta)) {
                btnA.setBackgroundColor(Color.parseColor("#45A163"));
                btnA.setTextColor(Color.parseColor("#FFFFFF"));
                nextResDelay(b, btnA);
            } else if (btnB.getText().toString().equals(respostaCerta)) {
                btnB.setBackgroundColor(Color.parseColor("#45A163"));
                btnB.setTextColor(Color.parseColor("#FFFFFF"));
                nextResDelay(b, btnB);
            } else if (btnC.getText().toString().equals(respostaCerta)) {
                btnC.setBackgroundColor(Color.parseColor("#45A163"));
                nextResDelay(b, btnC);
                btnC.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (btnD.getText().toString().equals(respostaCerta)) {
                btnD.setBackgroundColor(Color.parseColor("#45A163"));
                btnD.setTextColor(Color.parseColor("#FFFFFF"));
                nextResDelay(b, btnD);
            }
        }
        desabilitaBtn();
    }

    public void desabilitaBtn() {
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
    }

    public void habilitarBtn() {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
    }


    public void btnDefault(Button btn) {
        btn.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn.setTextColor(Color.parseColor("#FF0000"));
    }

    private void nextResDelay(final Button b) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                p++;
                btnDefault(b);
                verificaCasa();
                habilitarBtn();
            }
        }, 1500);
    }


    public void btnDefault(Button btn1, Button btn2) {
        btn1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn1.setTextColor(Color.parseColor("#FF0000"));
        btn2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        btn2.setTextColor(Color.parseColor("#FF0000"));
    }

    private void nextResDelay(final Button b, final Button btn) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                p++;
                btnDefault(b, btn);
                verificaCasa();
                habilitarBtn();
            }
        }, 1500);
    }
}

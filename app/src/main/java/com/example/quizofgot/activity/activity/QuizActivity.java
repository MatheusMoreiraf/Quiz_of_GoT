package com.example.quizofgot.activity.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.quizofgot.activity.activity.util.PerguntasERespostas;
import com.example.quizofgot.R;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    public static final int CONSTANTE_TELA_RESULTADO = 3;

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
    int acertos = 0;
    boolean paraThread = false;

    TextView textPergunta, textProgresso;
    Button btnA, btnB, btnC, btnD;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textPergunta = findViewById(R.id.textPergunta);
        textProgresso = findViewById(R.id.textProgresso);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        progressBar = findViewById(R.id.progressBar);
        verificaCasa();
    }

    @Override
    public void onBackPressed() {
    }

    public void carregarProgressBar() {
        paraThread = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 14; i++) {
                    if (paraThread)
                        return;
                    final int progresso = i;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progresso);
                            textProgresso.setText(String.valueOf(progresso + 1));
                            if (progresso == 14) {
                                desabilitaBtn();
                                tempoEsgotado();
                            }
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
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
                    Bundle result = new Bundle();
                    result.putString("Acertos", String.valueOf(acertos));
                    i.putExtras(result);
                    finish();
                    startActivityForResult(i, CONSTANTE_TELA_RESULTADO);
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
        progressBar.setProgress(0);
    }

    public void perguntasCasaStark() {
        pergunta = stark[0][p];
        respostaCerta = stark[1][p];
        auxList.clear();

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
        carregarProgressBar();
    }

    public void perguntasCasaTargaryen() {
        pergunta = targaryen[0][p];
        respostaCerta = targaryen[1][p];
        auxList.clear();

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
        carregarProgressBar();
    }

    public void perguntasCasaLannister() {
        pergunta = lannister[0][p];
        respostaCerta = lannister[1][p];
        auxList.clear();

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
        carregarProgressBar();
    }

    public void perguntasCasaGreyjoy() {
        pergunta = greyjoy[0][p];
        respostaCerta = greyjoy[1][p];
        auxList.clear();

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
        carregarProgressBar();
    }

    public void verificaResposta(View v) {
        paraThread = true;
        final Button b = (Button) v;

        if (b.getText().toString().equals(respostaCerta)) {
            b.setBackgroundResource(R.drawable.background_green);
            b.setTextColor(Color.parseColor("#FFFFFF"));
            this.acertos = this.acertos + 1;
            nextResDelay(b);
        } else {
            b.setBackgroundResource(R.drawable.background_red);
            b.setTextColor(Color.parseColor("#FFFFFF"));
            if (btnA.getText().toString().equals(respostaCerta)) {
                btnA.setBackgroundResource(R.drawable.background_green);
                btnA.setTextColor(Color.parseColor("#FFFFFF"));
                nextResDelay(b, btnA);
            } else if (btnB.getText().toString().equals(respostaCerta)) {
                btnB.setBackgroundResource(R.drawable.background_green);
                btnB.setTextColor(Color.parseColor("#FFFFFF"));
                nextResDelay(b, btnB);
            } else if (btnC.getText().toString().equals(respostaCerta)) {
                btnC.setBackgroundResource(R.drawable.background_green);
                nextResDelay(b, btnC);
                btnC.setTextColor(Color.parseColor("#FFFFFF"));
            } else if (btnD.getText().toString().equals(respostaCerta)) {
                btnD.setBackgroundResource(R.drawable.background_green);
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
        btn.setBackgroundResource(R.drawable.background_white);
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
        btn1.setBackgroundResource(R.drawable.background_white);
        btn1.setTextColor(Color.parseColor("#FF0000"));
        btn2.setBackgroundResource(R.drawable.background_white);
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

    private void tempoEsgotado() {
        textProgresso.setText("Tempo Esgotado");
        if (btnA.getText().toString().equals(respostaCerta)) {
            btnA.setBackgroundColor(Color.parseColor("#45A163"));
            btnA.setTextColor(Color.parseColor("#FFFFFF"));
            nextResDelay(btnA);
        } else if (btnB.getText().toString().equals(respostaCerta)) {
            btnB.setBackgroundColor(Color.parseColor("#45A163"));
            btnB.setTextColor(Color.parseColor("#FFFFFF"));
            nextResDelay(btnB);
        } else if (btnC.getText().toString().equals(respostaCerta)) {
            btnC.setBackgroundColor(Color.parseColor("#45A163"));
            nextResDelay(btnC);
            btnC.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (btnD.getText().toString().equals(respostaCerta)) {
            btnD.setBackgroundColor(Color.parseColor("#45A163"));
            btnD.setTextColor(Color.parseColor("#FFFFFF"));
            nextResDelay(btnD);
        }
    }
}

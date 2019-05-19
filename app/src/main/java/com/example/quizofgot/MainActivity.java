package com.example.quizofgot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    PerguntasERespostas casas = new PerguntasERespostas();

    String[][] stark = casas.casaStark;
    String[][] targaryen = casas.casaTargaryen;
    String[][] lannister = casas.casaLannister;
    String[][] greyjoy = casas.casaGreyjoy;

    Random gerador = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        perguntasCasaStark();
    }

    public void perguntasCasaStark() {

        String aux = "";
        String pergunta = "";
        String respostaCerta = "";
        String[] respostasErradas = new String[3];

        int p = 0;

        pergunta = stark[0][p];
        respostaCerta = stark[1][p];

        /*  Respostas Erradas */
        for (int i = 0; i < respostasErradas.length; i++) {
            int lin = gerador.nextInt((19 - 2) + 1) + 2;
            aux = stark[lin][p];
            for (int j = 0; j < respostasErradas.length; j++) {
                if (respostasErradas[j] == aux && j != i) {
                    aux = stark[gerador.nextInt((19 - 2) + 1) + 2][p];
                } else {
                    respostasErradas[i] = aux;
                }
            }
        }

        System.out.println("Teste : " + pergunta);
        System.out.println("Teste C: " + respostaCerta);
        for (int i = 0; i < respostasErradas.length; i++)
            System.out.println("Teste R: " + respostasErradas[i]);
        System.out.println("\nTest =================================\n");


    }

    public void perguntasCasaTargaryen() {
        for (int l = 0; l < targaryen.length; l++) {
            for (int c = 0; c < targaryen[l].length; c++) {
                System.out.println("Teste : " + targaryen[l][c]);
            }
        }
    }

    public void perguntasCasaLannister() {
        for (int l = 0; l < lannister.length; l++) {
            for (int c = 0; c < lannister[l].length; c++) {
                System.out.println("Teste : " + lannister[l][c]);
            }
        }
    }

    public void perguntasCasaGreyjoy() {
        for (int l = 0; l < greyjoy.length; l++) {
            for (int c = 0; c < greyjoy[l].length; c++) {
                System.out.println("Teste : " + greyjoy[l][c]);
            }
        }
    }
}

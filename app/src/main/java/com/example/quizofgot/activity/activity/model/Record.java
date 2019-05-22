package com.example.quizofgot.activity.activity.model;

public class Record {
    private String nome;
    private String pontuacao;

    public Record() {
    }

    public Record(String nome, String pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }
}

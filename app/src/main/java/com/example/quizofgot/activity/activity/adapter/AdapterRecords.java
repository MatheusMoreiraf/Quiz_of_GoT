package com.example.quizofgot.activity.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quizofgot.R;
import com.example.quizofgot.activity.activity.model.Record;

import java.util.List;

public class AdapterRecords extends RecyclerView.Adapter<AdapterRecords.MyViewHolder> {

    private List<Record> listPontuacao;

    public AdapterRecords(List<Record> list) {
        this.listPontuacao = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemLista = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_list_pontuacoes, viewGroup, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Record record = listPontuacao.get(i);
        myViewHolder.nome.setText(record.getNome());
        myViewHolder.pontuacao.setText(record.getPontuacao());
    }

    @Override
    public int getItemCount() {
        return listPontuacao.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView pontuacao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.textNome);
            pontuacao = itemView.findViewById(R.id.textPontuacao);
        }
    }
}
